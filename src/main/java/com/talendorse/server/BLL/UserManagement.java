package com.talendorse.server.BLL;

import com.talendorse.server.DTO.*;
import com.talendorse.server.model.tables.records.*;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.*;
import com.talendorse.server.DTO.RespuestaWSAllInfoUser;
import com.talendorse.server.DTO.RespuestaWSLogin;
import com.talendorse.server.DTO.RespuestaWSOfferUser;
import com.talendorse.server.DTO.RespuestaWSUser;
import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.tables.records.OffersRecord;
import com.talendorse.server.model.tables.records.TokensRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
import com.talendorse.server.util.*;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import static com.talendorse.server.util.Email.TextoMail;

public class UserManagement {
    private static int MIN_LEN_PWD = 8;

    public static RespuestaWSLogin Login(String username, String password) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        username = username.toLowerCase();
        UsersRecord usuario = connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.EMAIL.equal(username))
                .fetchAnyInto(UsersRecord.class);
        if (usuario == null) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);
        String pwd = usuario.getPassword().toLowerCase();
//        String salt = usuario.getSalt().toLowerCase();
//        String hashCompletodesdeBD = Seguridad.GenerarSHA56(pwd + salt);
//        if (!password.toLowerCase().equals(hashCompletodesdeBD))
        if (!password.toLowerCase().equals(pwd))
            throw new TalendorseException(TalendorseErrorType.LOGIN_ERROR);
//        if (usuario.getVerifiedEmail() == null || usuario.getVerifiedEmail() == 0
//                || usuario.getVerifiedPhoneNumber() == null || usuario.getVerifiedPhoneNumber() == 0)
        if (usuario.getVerifiedEmail() == null || usuario.getVerifiedEmail() == 0)
            throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);

        TokensRecord token = connection.create.newRecord(Tables.TOKENS);
        token.setIdUser(usuario.getIdUser());
        token.setToken(Util.getNewToken());
        token.setExpirationDate(Fechas.getTokenExpiration());
        token.store();

        RespuestaWSLogin respuestaWSUsuario = new RespuestaWSLogin(usuario.getTokenLinkedin(), usuario.getPictureUrl(), usuario.getEmail(),
                usuario.getName(), usuario.getSurname(), token.getToken());

        connection.closeConnection();
        return respuestaWSUsuario;
    }

    public static void check_token(String token_string) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        TokensRecord token = connection.create.select()
                .from(Tables.TOKENS)
                .where(Tables.TOKENS.TOKEN.equal(token_string))
                .fetchAnyInto(TokensRecord.class);

        if(token == null) throw new TalendorseException(TalendorseErrorType.TOKEN_NOT_FOUND);
    }


    public static String InsertarUsuario(String email, String password, String name, String surname, String birthday, String gender,
                                         String salt, String idioma, String telefono, String url) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        email = email.trim();
        password = password.trim();
        name = name.trim();
        surname = surname.trim();
        ValidacionParametros(email, password, name, surname, salt);
        String emailEncriptado = EncriptarEmailoTelefono(email.toLowerCase());
        UsersRecord usuario = connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.EMAIL.equal(emailEncriptado))
                .fetchAnyInto(UsersRecord.class);

        if (usuario != null) throw new TalendorseException(TalendorseErrorType.USER_ALREADY_EXISTS);

        UsersRecord usr = connection.create.newRecord(Tables.USERS);

        usr.setEmail(emailEncriptado);
        usr.setTokenLinkedin(UUID.randomUUID().toString());
        usr.setName(name);
        usr.setSurname(surname);
        usr.setPictureUrl("/Upload/User/" + Seguridad.GenerateSecureRandomString() + "/" + Seguridad.GenerarRandomFileName() + "_thumb.jpg");
        usr.setDateBirthday(Fechas.getCurrentTimestampLong());
        usr.setPassword(password);
        usr.setSalt(salt);//Seguridad.GenerarSHA56(String.valueOf(Integer.parseInt(salt) * 8)));
        usr.setPhoneNumber(EncriptarEmailoTelefono(telefono));
        usr.setVerifiedPhoneNumber(1);
        usr.setLanguage(idioma);
        usr.setGender(gender);
        usr.store();

//        String subjectCorreoEstablecimiento;
//        if (idioma != null) {
//            if (idioma.toLowerCase().equals("es")) {
//                subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_ES;
//            } else {
//                // By default language
//                subjectCorreoEstablecimiento = Constantes.EMAIL_SUBJECT_RECOVER_PASSWORD_EN;
//            }
//        } else {
//            // By default language
//            subjectCorreoEstablecimiento = "Bienvenido a Jobster"; //TODO: constantes mail HttpContext.GetGlobalResourceObject("Literales", "subject2", System.Globalization.CultureInfo.CreateSpecificCulture("en")).ToString();
//        }
//
//        try {
//            String enlace = url + "Activate?enlace=" + URLEncoder.encode(EncriptarEnlace(usr.getApikey()), java.nio.charset.StandardCharsets.UTF_8.toString());
//            String textoEmail = TextoMail(enlace + "&lang=" + idioma, "mail/Activate.aspx", url, "&lang=" + idioma, usr.getUserName());
//
//            Email.sendEmail(usr.getEmail(), subjectCorreoEstablecimiento, textoEmail);
//        } catch (UnsupportedEncodingException e) {
//            throw new TalendorseException(TalendorseErrorType.ENCRYPTING_ERROR);
//        }

        connection.closeConnection();
        return usr.getTokenLinkedin();
    }



    public static String insertarUsuario_temp(String name, String surname, String password, String gender, String email, String url)  throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        UsersRecord usr = connection.create.newRecord(Tables.USERS);

        usr.setName(name);
        usr.setSurname(surname);
        usr.setEmail(email.trim());
        usr.setGender(gender);
        usr.setPassword(password);
        usr.setLanguage("es");
        usr.setTokenLinkedin(UUID.randomUUID().toString());
        usr.setValidationToken(UUID.randomUUID().toString());
        usr.setPictureUrl("/Upload/User/" + Seguridad.GenerateSecureRandomString() + "/" + Seguridad.GenerarRandomFileName() + "_thumb.jpg");
        usr.setDateBirthday(Fechas.getCurrentTimestampLong());
        usr.setSalt("trnmnmfysxmzxf");
        usr.setPhoneNumber("+34658632698"); //EncriptarEmailoTelefono("+34658632698")); //TODO: encriptar telefono
        usr.setVerifiedPhoneNumber(0);
        usr.store();

        String url_location = Constantes.URL_EMAIL_VALIDATION_ACCOUNT_URL_ES;
        String email_subject = Constantes.EMAIL_SUBJECT_USER_ACTIVATION_ES;

        String textoEmail = Email.TextoMail(url, url_location);
        textoEmail = textoEmail.replace("user_name_endorser", usr.getName());
        textoEmail = textoEmail.replace("url_endorser_validation", Constantes.WS_TALENDORSE_URL+
                "email/activation_es?activation_token="+ usr.getValidationToken());

        Email.sendEmail(email, email_subject, textoEmail);

        return "OK";
    }

    private static void ValidacionParametros(String email, String password, String name, String surname, String salt) throws TalendorseException {

        if (!ValidarTipos.EsEmailValido(email))
            throw new TalendorseException(TalendorseErrorType.INVALID_MAIL_FORMAT);

        if (!ValidarTipos.ValidatePassword(password))
            throw new TalendorseException(TalendorseErrorType.INVALID_PASSWORD_FORMAT);

        if ((name == null) || (name.isEmpty()))
            throw new TalendorseException(TalendorseErrorType.INVALID_NAME);

        if ((surname == null) || (surname.isEmpty()))
            throw new TalendorseException(TalendorseErrorType.INVALID_SURNAME);

        if (password.length() <= (UserManagement.MIN_LEN_PWD - 1))
            throw new TalendorseException(TalendorseErrorType.PASSWORD_TOO_SHORT);
    }

    public static String EncriptarEnlace(String apiKey) throws TalendorseException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String enlace = calendar.get(Calendar.YEAR) + Constantes.PATTERN_SPLIT +
                apiKey + Constantes.PATTERN_SPLIT +
                calendar.get(Calendar.MONTH) + Constantes.PATTERN_SPLIT +
                calendar.get(Calendar.DAY_OF_MONTH) + Constantes.PATTERN_SPLIT +
                calendar.get(Calendar.HOUR) + Constantes.PATTERN_SPLIT +
                UUID.randomUUID().toString() + Constantes.PATTERN_SPLIT +
                calendar.get(Calendar.MINUTE);

        return Base64.getEncoder().encodeToString(criptografiaSimetrica.encriptar(enlace));
    }

    public static UsersRecord GetUserfromApiKey(String apiKey) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        UsersRecord usr = connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.TOKEN_LINKEDIN.equal(apiKey))
                .fetchAnyInto(UsersRecord.class);

        connection.closeConnection();
        return usr;
    }


    public static String GetUserTokenFromId(int id) throws  TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        String tknUsr = connection.create.select().from(Tables.USERS).where(Tables.USERS.ID_USER.contains(id)).fetchSingle(Tables.USERS.VALIDATION_TOKEN);
        return tknUsr;
    }

    public static UsersRecord GetUserfromToken(DSLContext create, String token) throws TalendorseException {
        int idUsr = create.select().from(Tables.TOKENS).where(Tables.TOKENS.TOKEN.contains(token)).fetchSingle(Tables.TOKENS.ID_USER);

        UsersRecord usr = create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.ID_USER.contains(idUsr))
                .fetchAnyInto(UsersRecord.class);

        return usr;
    }

    public static RespuestaWSUser UserInformation(String token) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        UsersRecord usuario = GetUserfromToken(connection.create, token);
        if (usuario == null) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);
        String urlThumbnail = usuario.getPictureUrl();
        String urlAvatar = "";
        if ((urlThumbnail != null) && (!urlThumbnail.isEmpty())) {
            urlAvatar = urlThumbnail;
        }
        usuario.setLastConnection(Fechas.getCurrentTimestampLong());
        usuario.store();

        connection.closeConnection();
        return new RespuestaWSUser(usuario.getName(), usuario.getSurname(), usuario.getEmail(), urlAvatar, usuario.getPhoneNumber(), usuario.getIdUser());
    }

    public static String LogOut(String apiKey) throws TalendorseException {
        //Habria que borrar el APIKEY a uno distinto o algo
//        UsersRecord usuario = GetUserfromApiKey(apiKey);
//        if (usuario == null) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);
        return "OK";
    }


    private static String EncriptarEmailoTelefono(String data) throws TalendorseException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);
        return Base64.getEncoder().encodeToString(criptografiaSimetrica.encriptar(data));
    }

    private static String DesencriptarEmailoTelefono(String dataEnc) throws TalendorseException {
        CriptografiaSimetrica criptografiaSimetrica = new CriptografiaSimetrica(CriptografiaSimetrica.CryptoProvider.AES);
        criptografiaSimetrica.setKey(Constantes.CLAVE_ENCRIPTACION);
        criptografiaSimetrica.setIV(Constantes.VI_ENCRIPTACION);
        return criptografiaSimetrica.desencriptar(Base64.getDecoder().decode(dataEnc));
    }

    public static RespuestaWSAllInfoUser getAllInfoUser(Integer idUser) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        UsersRecord usr = getUser(connection, idUser);

        List<Integer> ids_list = connection.create.select().from(Tables.USERS_SKILLS).where(Tables.USERS_SKILLS.ID_USER.equal(idUser)).fetch(Tables.USERS_SKILLS.ID_SKILL);
        List<String> skills_list = connection.create.select().from(Tables.SKILLS).where(Tables.SKILLS.ID_SKILL.in(ids_list)).fetch(Tables.SKILLS.NAME);

        ids_list = connection.create.select().from(Tables.USER_LANGUAGE).where(Tables.USER_LANGUAGE.ID_USER.equal(idUser)).fetch(Tables.USER_LANGUAGE.ID_LANGUAGE);
        List<String> idioms_list = connection.create.select().from(Tables.LANGUAGES).where(Tables.LANGUAGES.ID_LANGUAGE.in(ids_list)).fetch(Tables.SKILLS.NAME);

        connection.closeConnection();
        return new RespuestaWSAllInfoUser(usr, skills_list, idioms_list);
    }

    public static List<RespuestaWSUser> getAllUsers() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        Result<Record> result = connection.create.select().from(Tables.USERS).fetch();

        List<RespuestaWSUser> listUsers = new ArrayList<>();
        for (Record r : result) {
            RespuestaWSUser user = new RespuestaWSUser (
                    r.getValue(Tables.USERS.NAME),
                    r.getValue(Tables.USERS.SURNAME),
                    r.getValue(Tables.USERS.EMAIL),
                    r.getValue(Tables.USERS.PICTURE_URL),
                    r.getValue(Tables.USERS.PHONE_NUMBER),
                    r.getValue(Tables.USERS.ID_USER));
            listUsers.add(user);
        }
        connection.closeConnection();
        return listUsers;
    }

    public static boolean userExist(DSLContext create, int id_user) {
        UsersRecord usr = create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.ID_USER.equal(id_user))
                .fetchAnyInto(UsersRecord.class);

        return usr != null;
    }

    public static String getIdiom(DSLContext create, int id_user) {
        UsersRecord usr = create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.ID_USER.equal(id_user))
                .fetchAnyInto(UsersRecord.class);
        return usr.getLanguage();
    }

    public static String validateEmail(String token) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        UsersRecord user = getUserToken(connection, token);

        user.setVerifiedEmail(1);
        user.setValidationToken(null);
        user.store();
        connection.closeConnection();
        return "OK";
    }

    public static List<RespuestaWSOfferUser> getAllUserOffers(int idUser) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        List<RespuestaWSOfferUser> listOffers = new ArrayList<>();
        Result<Record> referals = connection.create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_CANDIDATE.equal(idUser).or(Tables.REFERRALS.ID_ENDORSER.equal(idUser)))
                .fetch();

        for (Record ref : referals) {
            OffersRecord off = connection.create.select()
                    .from(Tables.OFFERS)
                    .where(Tables.OFFERS.ID_OFFER.equal(ref.getValue(Tables.REFERRALS.ID_OFFER)))
                    .fetchAnyInto(OffersRecord.class);

            if (off == null) throw new TalendorseException(TalendorseErrorType.OFFER_NOT_EXISTS);

            UsersRecord endorser = connection.create.select().from(Tables.USERS).where(Tables.USERS.ID_USER.equal(ref.getValue(Tables.REFERRALS.ID_ENDORSER))).fetchAnyInto(UsersRecord.class);
            if (endorser == null) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);

            CompaniesRecord company = CompaniesManagement.getCompanyRecord(connection.create, off.getValue(Tables.OFFERS.ID_COMPANY));

            RespuestaWSOfferUser respues = new RespuestaWSOfferUser(ref.getValue(Tables.REFERRALS.ID_REFERRAL), ref.getValue(Tables.REFERRALS.ID_OFFER),
                    ref.getValue(Tables.REFERRALS.STATE), ref.getValue(Tables.REFERRALS.ID_ENDORSER), endorser.getName(),
                    endorser.getSurname(), ref.getValue(Tables.REFERRALS.EMAIL_CANDIDATE), company.getValue(Tables.COMPANIES.NAME),
                    company.getValue(Tables.COMPANIES.PATH_IMG), off.getPosition(), off.getSummary(), ref.getValue(Tables.REFERRALS.DATE_CREATION),
                    ref.getValue(Tables.REFERRALS.DATE_ACCEPTED), off.getDateEnd());

            if(ref.getValue(Tables.REFERRALS.ID_CANDIDATE) != null) {
                UsersRecord candidate = connection.create.select()
                        .from(Tables.USERS)
                        .where(Tables.USERS.ID_USER.equal(ref.getValue(Tables.REFERRALS.ID_CANDIDATE)))
                        .fetchAnyInto(UsersRecord.class);

                if (candidate == null) throw new TalendorseException(TalendorseErrorType.CANDIDATE_NOT_FOUND);

                respues.setIdCandidato(ref.getValue(Tables.REFERRALS.ID_CANDIDATE));
                respues.setName_candidate(candidate.getName());
                respues.setSurname_candidate(candidate.getSurname());
            }
            listOffers.add(respues);
        }
        connection.closeConnection();
        return  listOffers;
    }

    public static UsersRecord getUser(int idUser) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        UsersRecord user = getUser(connection, idUser);
        connection.closeConnection();
        return  user;
    }

    public static UsersRecord getUser(ConnectionBDManager connection, int idUser) throws TalendorseException {
        UsersRecord user = connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.ID_USER.equal(idUser))
                .fetchAnyInto(UsersRecord.class);

        if (user == null) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);
        return user;
    }

    private static UsersRecord getUserToken(ConnectionBDManager connection, String token) throws TalendorseException {
        UsersRecord user = connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.VALIDATION_TOKEN.equal(token))
                .fetchAnyInto(UsersRecord.class);

        if (user == null) throw new TalendorseException(TalendorseErrorType.TOKEN_NOT_FOUND);
        return user;
    }

    public static String emailValidateUser(String url, int id_user, String idiom) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        UsersRecord user = UserManagement.getUser(connection, id_user);

        String url_location;
        String email_subject;

        if(idiom.equals("es")) {
            url_location = Constantes.URL_EMAIL_VALIDATION_ACCOUNT_URL_ES;
            email_subject = Constantes.EMAIL_SUBJECT_USER_ACTIVATION_ES;
        }
        else {
            url_location = Constantes.URL_EMAIL_VALIDATION_ACCOUNT_URL_EN;
            email_subject = Constantes.EMAIL_SUBJECT_USER_ACTIVATION_EN;
        }

        String textoEmail = TextoMail(url, url_location);
        textoEmail = textoEmail.replace("user_name_endorser", user.getName());
        textoEmail = textoEmail.replace("url_endorser_validation", url+
                "talendorse/email/account_activated.html?activation_token="+ user.getValidationToken());

        Email.sendEmail(user.getEmail(), email_subject, textoEmail);

        connection.closeConnection();
        return "OK";
    }

    public static UsersRecord getUserbyIdLinkedIn(ConnectionBDManager connection, String id_linkedId) {
        return connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.ID_LINKEDIN.equal(id_linkedId))
                .fetchAnyInto(UsersRecord.class);
    }

    public static UsersRecord getUserbyEmail(ConnectionBDManager connection, String email) {
        return connection.create.select()
                .from(Tables.USERS)
                .where(Tables.USERS.EMAIL.equal(email))
                .fetchAnyInto(UsersRecord.class);
    }

    public static void copyUserFromLinkedInUSer(UsersRecord linkedinUser, UsersRecord user) {
        user.setTokenLinkedin(linkedinUser.getTokenLinkedin());
        user.setIdLinkedin(linkedinUser.getIdLinkedin());
        user.setName(linkedinUser.getName());
        user.setSurname(linkedinUser.getSurname());
        user.setEmail(linkedinUser.getEmail());
        user.setLanguage(linkedinUser.getLanguage());
        user.setPictureUrl(linkedinUser.getPictureUrl());
        user.setThumbUrl(linkedinUser.getThumbUrl());
    }
}
