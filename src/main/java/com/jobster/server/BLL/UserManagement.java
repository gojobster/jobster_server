package com.jobster.server.BLL;

import com.jobster.server.DTO.RespuestaWS;
import com.jobster.server.DTO.RespuestaWSAllInfoUser;
import com.jobster.server.DTO.RespuestaWSLogin;
import com.jobster.server.DTO.RespuestaWSUser;
import com.jobster.server.model.Jobster;
import com.jobster.server.model.tables.records.SkillsRecord;
import com.jobster.server.model.tables.records.UsersRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import static com.jobster.server.model.Tables.*;

public class UserManagement {

    private static int MIN_LEN_PWD = 8;

    public static RespuestaWSLogin Login(String username, String password) throws JobsterException {

        username = username.toLowerCase();
        //conectamos al jooq
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            UsersRecord usuario = create.select()
                    .from(USERS)
                    .where(USERS.EMAIL.equal(username))
                    .fetchAnyInto(UsersRecord.class);
            if (usuario == null) throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);
            String pwd = usuario.getPassword().toLowerCase();
            String salt = usuario.getSalt().toLowerCase();
            String hashCompletodesdeBD = Seguridad.GenerarSHA56(pwd + salt);
            if (password.toLowerCase().equals(hashCompletodesdeBD))
                throw new JobsterException(JobsterErrorType.LOGIN_ERROR);
            if (usuario.getVerifiedEmail() == null || usuario.getVerifiedEmail() == 0
                    || usuario.getVerifiedPhoneNumber() == null || usuario.getVerifiedPhoneNumber() == 0)
                throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);
            RespuestaWSLogin respuestaWSUsuario = new RespuestaWSLogin(usuario.getApikey(), usuario.getPictureUrl(), usuario.getEmail(),
                    usuario.getName(), usuario.getSurrname());
            create.close();
            conn.close();
            return respuestaWSUsuario;
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static String InsertarUsuario(String email, String password, String name, String surname, String birthday, String gender,
                                         String salt, String idioma, String telefono, String url) throws JobsterException {
        email = email.trim();
        password = password.trim();
        name = name.trim();
        surname = surname.trim();
        ValidacionParametros(email, password, name, surname, salt);
        String emailEncriptado = EncriptarEmailoTelefono(email.toLowerCase());
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            UsersRecord usuario = create.select()
                    .from(USERS)
                    .where(USERS.EMAIL.equal(emailEncriptado))
                    .fetchAnyInto(UsersRecord.class);

            if (usuario != null) throw new JobsterException(JobsterErrorType.USER_ALREADY_EXISTS);

            UsersRecord usr = create.newRecord(USERS);

            usr.setEmail(emailEncriptado);
            usr.setApikey(UUID.randomUUID().toString());
            usr.setName(name);
            usr.setSurrname(surname);
            usr.setPictureUrl("/Upload/User/" + Seguridad.GenerateSecureRandomString() + "/" + Seguridad.GenerarRandomFileName() + "_thumb.jpg");
            usr.setDateBirthday(Fechas.GetCurrentTimestampLong());
            usr.setLastConnection(Fechas.GetCurrentTimestampLong());
            usr.setPassword(password);
            usr.setSalt(salt);//Seguridad.GenerarSHA56(String.valueOf(Integer.parseInt(salt) * 8)));
            usr.setPhoneNumber(EncriptarEmailoTelefono(telefono));
            usr.setVerifiedPhoneNumber(1);
            usr.setIdiom(idioma);
            usr.setDateCreated(Fechas.GetCurrentTimestampLong());
            usr.setGender(gender);
            usr.store();

            String subjectCorreoEstablecimiento;
            if (idioma != null) {
                if (idioma.toLowerCase().equals("es")) {
                    subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_ES;
                } else {
                    // By default language
                    subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_EN;
                }
            } else {
                // By default language
                subjectCorreoEstablecimiento = "ccc"; //TODO: constantes mail HttpContext.GetGlobalResourceObject("Literales", "subject2", System.Globalization.CultureInfo.CreateSpecificCulture("en")).ToString();
            }
            String enlace = url + "Activate?enlace=" + URLEncoder.encode(EncriptarEnlace(usr.getApikey()), java.nio.charset.StandardCharsets.UTF_8.toString());
            Email correo = new Email(Constantes.SRV_EMAIL_FROM_ACCOUNT, Constantes.SRV_EMAIL_HOST, Constantes.SRV_EMAIL_PORT, Constantes.SRV_EMAIL_USR, Constantes.SRV_EMAIL_PWD, Constantes.SRV_EMAIL_ENABLE_SSL);
            //TODO: arreglar plantilla
            //String textoEmail = "Prueba";//TextoMail(enlace + "&lang=" + idioma, "mail/Activate.aspx", url, "&lang=" + idioma);
            //correo.sendEmail(usr.getEmail(), subjectCorreoEstablecimiento, textoEmail, true);

            create.close();
            conn.close();
            return usr.getApikey();
        } catch (InstantiationException | SQLException | IllegalAccessException | UnsupportedEncodingException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static void RecuperarContrasenya(String email, String url) throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            //miramos si existe ya el mail o el telefono y si existe se le dice q repetido!
            UsersRecord usuario = create.select().from(USERS)
                    .where(USERS.EMAIL.equal(email))
                    .fetchAnyInto(UsersRecord.class);
            if (usuario == null) throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);
            String subjectCorreoEstablecimiento;
            if (usuario.getIdiom() != null) {
                if (usuario.getIdiom().toLowerCase().equals("es")) {
                    subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_ES;
                } else {
                    // By default language
                    subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_EN;
                }
            } else {
                // By default language
                subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_EN;
            }
            String enlace = url + "recuperarpwd.aspx?enlace=" + URLEncoder.encode(EncriptarEnlace(usuario.getApikey()), java.nio.charset.StandardCharsets.UTF_8.toString());

            //TODO GENERAR PLANTILLA HTML
            Email correo = new Email(Constantes.SRV_EMAIL_FROM_ACCOUNT, Constantes.SRV_EMAIL_HOST, Constantes.SRV_EMAIL_PORT, Constantes.SRV_EMAIL_USR, Constantes.SRV_EMAIL_PWD, Constantes.SRV_EMAIL_ENABLE_SSL);
            String textoEmail = TextoMail(enlace + "&lang=" + usuario.getIdiom(), "/mail/RecoverPWD.aspx", url, "&lang=" + usuario.getIdiom());

            create.close();
            correo.sendEmail(email, subjectCorreoEstablecimiento, textoEmail, true);
        } catch (UnsupportedEncodingException | ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    private static void ValidacionParametros(String email, String password, String name, String surname, String salt) throws JobsterException {

        if (!ValidarTipos.EsEmailValido(email))
            throw new JobsterException(JobsterErrorType.INVALID_MAIL_FORMAT);

        if (!ValidarTipos.ValidatePassword(password))
            throw new JobsterException(JobsterErrorType.INVALID_PASSWORD_FORMAT);

        if ((name == null) || (name.isEmpty()))
            throw new JobsterException(JobsterErrorType.INVALID_NAME);

        if ((surname == null) || (surname.isEmpty()))
            throw new JobsterException(JobsterErrorType.INVALID_SURNAME);

        if (password.length() <= (UserManagement.MIN_LEN_PWD - 1))
            throw new JobsterException(JobsterErrorType.PASSWORD_TOO_SHORT);
    }

    private static String EncriptarEnlace(String apiKey) throws JobsterException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String enlace = String.valueOf(calendar.get(Calendar.YEAR)) + Constantes.PATHERN_SPLIT +
                apiKey + Constantes.PATHERN_SPLIT +
                String.valueOf(calendar.get(Calendar.MONTH)) + Constantes.PATHERN_SPLIT +
                String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + Constantes.PATHERN_SPLIT +
                String.valueOf(calendar.get(Calendar.HOUR)) + Constantes.PATHERN_SPLIT +
                UUID.randomUUID().toString() + Constantes.PATHERN_SPLIT +
                String.valueOf(calendar.get(Calendar.MINUTE));

        return Base64.getEncoder().encodeToString(criptografiaSimetrica.encriptar(enlace));
    }

    private static String TextoMail(String enlace, String localizacionPlantillaEmail, String url, String idioma) throws JobsterException {
        //Util40.ClienteWebPost post = new Util40.ClienteWebPost(url + localizacionPlantillaEmail + "?enlace=" + System.Web.HttpUtility.UrlEncode(enlace));
        //List<KeyValuePair<string, string>> listaParametros = new List<KeyValuePair<string, string>>();
        //listaParametros.Add(new KeyValuePair<string, string>("enlace", enlace));
        //return post.EnviarDatosServidorGet();
        //TODO PLANTILLA HTML MAIL
        url = url.replace("https://", "http://");

        //Util40.CriptografiaSimetrica criptografiaSimetrica = new Util40.CriptografiaSimetrica(Util40.CriptografiaSimetrica.CryptoProvider.AES);
        //criptografiaSimetrica.Key = Constantes.CLAVE_ENCRIPTACION;
        //criptografiaSimetrica.IV = Constantes.VI_ENCRIPTACION;
        //String x = Convert.ToBase64String(criptografiaSimetrica.Encriptar(System.Web.HttpUtility.UrlEncode(enlace)), Base64FormattingOptions.None);

        try {
            return GetURLContent(url + localizacionPlantillaEmail + "?enlace=" + URLEncoder.encode(enlace, java.nio.charset.StandardCharsets.UTF_8.toString()) + idioma);
        } catch (UnsupportedEncodingException e) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }

    }

    private static String GetURLContent(String laURL) {

        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(laURL);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            //TODO CHECK EXCEPTION
            e.printStackTrace();
        }
        return content.toString();

    }

    public static UsersRecord GetUserfromApiKey(String apiKey) throws JobsterException {
            DSLContext create = CreateContextConnection();
            return create.select()
                    .from(USERS)
                    .where(USERS.APIKEY.equal(apiKey))
                    .fetchAnyInto(UsersRecord.class);
    }

    private static DSLContext CreateContextConnection() throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            return DSL.using(conn, SQLDialect.MYSQL);
        } catch (InstantiationException | IllegalAccessException |ClassNotFoundException | SQLException e) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static RespuestaWSUser UserInformation(String apiKey) throws JobsterException {
        UsersRecord usuario = GetUserfromApiKey(apiKey);
        if (usuario == null) throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);
        String urlThumbnail = usuario.getPictureUrl();
        String urlAvatar = "";
        if ((urlThumbnail != null) && (!urlThumbnail.isEmpty())) {
            urlAvatar = urlThumbnail;
        }
        usuario.setLastConnection(Fechas.GetCurrentTimestampLong());
        usuario.store();
        return new RespuestaWSUser(urlAvatar, usuario.getEmail(), usuario.getName(), usuario.getSurrname(), usuario.getPhoneNumber());
    }

    public static String LogOut(String apiKey) throws JobsterException {
        //Habria que borrar el APIKEY a uno distinto o algo
        UsersRecord usuario = GetUserfromApiKey(apiKey);
        if (usuario == null) throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);
        return "OK";
    }


    private static String EncriptarEmailoTelefono(String data) throws JobsterException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);
        return Base64.getEncoder().encodeToString(criptografiaSimetrica.encriptar(data));
    }

    private static String DesencriptarEmailoTelefono(String dataEnc) throws JobsterException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);
        return criptografiaSimetrica.desencriptar(Base64.getDecoder().decode(dataEnc));
    }

    public static RespuestaWSAllInfoUser getAllInfoUser(Integer idUser) throws JobsterException{
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

             UsersRecord usr = create.select().from(USERS).where(USERS.ID_USER.equal(idUser)).fetchAnyInto(UsersRecord.class);
            if (usr == null) throw new JobsterException(JobsterErrorType.USER_NOT_FOUND);

            List<Integer> ids_list = create.select().from(USERS_SKILLS).where(USERS_SKILLS.ID_USER.equal(idUser)).fetch(USERS_SKILLS.ID_SKILL);
            List<String> skills_list = create.select().from(SKILLS).where(SKILLS.ID_SKILL.in(ids_list)).fetch(SKILLS.NAME);

            ids_list = create.select().from(USER_IDIOM).where(USER_IDIOM.ID_USER.equal(idUser)).fetch(USER_IDIOM.ID_IDIOM);
            List<String> idioms_list = create.select().from(IDIOMS).where(IDIOMS.ID_IDIOM.in(ids_list)).fetch(SKILLS.NAME);

            return new RespuestaWSAllInfoUser(usr, skills_list, idioms_list);

        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static List<RespuestaWSUser> getAllUsers() throws JobsterException{
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);


            Result<Record> result = create.select().from(USERS).fetch();

            List<RespuestaWSUser> listUsers = new ArrayList<>();
            for (Record r : result) {
                RespuestaWSUser user = new RespuestaWSUser ( r.getValue(USERS.NAME), r.getValue(USERS.SURRNAME),
                        r.getValue(USERS.EMAIL), r.getValue(USERS.PICTURE_URL), r.getValue(USERS.PHONE_NUMBER));
                listUsers.add(user);
            }
            return listUsers;
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static boolean userExist(DSLContext create, int id_user) {
        UsersRecord usr = create.select()
                .from(USERS)
                .where(USERS.ID_USER.equal(id_user))
                .fetchAnyInto(UsersRecord.class);

        return usr != null;
    }
}
