package com.talendorse.server.BLL;

import com.talendorse.server.model.Keys;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
import com.talendorse.server.types.StatusType;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.Email;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.util.RandomString;
import com.talendorse.server.model.Tables;
import org.jooq.DSLContext;

public class EndorsementManagement {

//    public static String addRecommendations(int id_offer, int id_user, String email, String url) throws TalendorseException {
//        ConnectionBDManager connection = new ConnectionBDManager();
//
//        email = email.trim();
//
//        if (!UserManagement.userExist(connection.create, id_user)) throw new TalendorseException(TalendorseErrorType.USER_NOT_EXISTS);
//        if (!OffersManagement.offerExist(connection.create, id_offer)) throw new TalendorseException(TalendorseErrorType.OFFER_NOT_EXISTS);
//        if (recomendationExist(connection.create, id_offer, email)) throw new TalendorseException(TalendorseErrorType.REFERRAL_EXISTS);
//
//        String user_idiom = UserManagement.getIdiom(connection.create, id_user);
//
//        String subject;
//        if (user_idiom != null) {
//            if (user_idiom.toLowerCase().equals("es")) {
//                subject = Constantes.EMAIL_SUBJECT_OFFER_RECOMENDATION_ES;
//            } else {
//                // By default language
//                subject = Constantes.EMAIL_SUBJECT_OFFER_RECOMENDATION_EN;
//            }
//        } else {
//            // By default language
//            subject = Constantes.EMAIL_SUBJECT_OFFER_RECOMENDATION_EN;
//        }
//
//        //String enlace = url + "recuperarpwd.aspx?enlace=" + URLEncoder.encode(UserManagement.EncriptarEnlace("rohnwe5489nw48n9sgpboz5svba9894579"), java.nio.charset.StandardCharsets.UTF_8.toString());
//        String textoEmail2 = UserManagement.TextoMail(url, Constantes.URL_EMAIL_SEND_RECOMMENDATION_URL_ES);
//
//        //TODO:Modificar textos para la recomendacion
//
//        Email.sendEmail(email, subject, textoEmail2);
//
//        ReferralsRecord ref = connection.create.newRecord(Tables.REFERRALS);
//        ref.setIdEndorser(id_user);
//        ref.setIdOffer(id_offer);
//        ref.setCode(getRandomCodeOffer());
//        ref.setEmailCandidate(email);
//        ref.store();
//
//        connection.closeConnection();
//
//        return "OK";
//    }

    private static boolean recomendationLimit(DSLContext create, int id_offer, String email) {
        int num = create.selectCount()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_OFFER.equal(id_offer).and(Tables.REFERRALS.EMAIL_CANDIDATE.equal(email)))
                .fetchOne(0, int.class);
//TODO: obtener el real

        return num >= Constantes.MAX_RECOMENDATION_PER_OFFER;
    }

    private static String getRandomCodeOffer() throws TalendorseException {
        boolean validCode = false;
        String code = "";

        ConnectionBDManager connection = new ConnectionBDManager();

        for(int i=0; i<Constantes.NUM_RANDOM_INTENTS_CODE_OFFER && !validCode; i++) {
            code = RandomString.generateCodeOffer(8);

            ReferralsRecord offer = connection.create.select()
                    .from(Tables.REFERRALS)
                    .where(Tables.REFERRALS.CODE.equal(code))
                    .fetchAnyInto(ReferralsRecord.class);

            if (offer == null) validCode = true;
        }

        connection.closeConnection();
        return code;
    }

    public static UsersRecord getEndorser(String referral_code) throws TalendorseException{
        return getReferralByCode(referral_code).fetchParent(Keys.FK_JOBSTER);
    }

    public static UsersRecord getCandidate(String referral_code) throws TalendorseException{
        return getReferralByCode(referral_code).fetchParent(Keys.FK_CANDIDATO);
    }

    private static ReferralsRecord getReferralByCode(String referral_code) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();

        ReferralsRecord ref = connection.create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.CODE.equal(referral_code))
                .fetchAnyInto(ReferralsRecord.class);

        connection.closeConnection();
        return  ref;
    }


    public static String sendRecomendatioToCandidate(int id_endorser, int id_offer, String email_candidate, String nameCandidate, int relation, String description) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();

        email_candidate = email_candidate.trim();

        if(!UserManagement.userExist(connection.create, id_endorser)) throw new TalendorseException(TalendorseErrorType.USER_NOT_EXISTS);
        if (!OffersManagement.offerExist(connection.create, id_offer)) throw new TalendorseException(TalendorseErrorType.OFFER_NOT_EXISTS);
        if (recomendationLimit(connection.create, id_offer, email_candidate)) throw new TalendorseException(TalendorseErrorType.REFERRAL_EXCEED_LIMIT);
        //TODO: prevenir SPAN a un usuario con mulyiples recomendaciones.

        try {
            ReferralsRecord ref = connection.create.newRecord(Tables.REFERRALS);

            ref.setIdOffer(id_offer);
            ref.setIdEndorser(id_endorser);
            ref.setCode(getRandomCodeOffer());
            ref.setEmailCandidate(email_candidate);
            ref.setNamecandidate(nameCandidate);
            ref.setRelation(relation);
            ref.setDescription(description);
            ref.store();
            connection.closeConnection();

            UsersRecord user = UserManagement.getUser(id_endorser);

            Email.sendEmailrecomendation(email_candidate, user.getName() + " " + user.getSurname(), nameCandidate, ""+ref.getIdOffer(), ref.getCode());

        } catch (Exception e) {
            e.printStackTrace();
            throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
        }

        return "OK";
    }

    public static String applyCandidate(Integer id_candidate, Integer idOffer, String code) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();

        if(code == "") throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
        if(!UserManagement.userExist(connection.create, id_candidate)) throw new TalendorseException(TalendorseErrorType.USER_NOT_EXISTS);

        ReferralsRecord ref = connection.create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.CODE.equal(code)).and(Tables.REFERRALS.ID_OFFER.equal(idOffer))
                .fetchAnyInto(ReferralsRecord.class);

        if(ref == null) throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);

        ref.setIdCandidate(id_candidate);
        ref.setState(StatusType.IN_PROGRESS.toInt());
        ref.setCode("");
        ref.setDateAccepted(Fechas.getCurrentTimestampLong());
        ref.store();

        connection.closeConnection();

        return "OK";
    }
}
