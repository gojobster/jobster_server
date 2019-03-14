package com.jobster.server.BLL;

import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.model.tables.records.ReferralsRecord;
import com.jobster.server.model.tables.records.SkillsRecord;
import com.jobster.server.model.tables.records.UsersRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.Fechas;
import com.jobster.server.util.RandomString;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jobster.server.model.Tables.*;

public class RecomendationsManagement {

    public static String addRecommendations(int id_offer, int id_user, String email) throws JobsterException{
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            email = email.trim();

            if (!UserManagement.userExist(create, id_user)) throw new JobsterException(JobsterErrorType.USER_NOT_EXISTS);
            if (!OffersManagement.offerExist(create, id_offer)) throw new JobsterException(JobsterErrorType.OFFER_NOT_EXISTS);
            if (recomendationExist(create, id_offer, email)) throw new JobsterException(JobsterErrorType.REFERRAL_EXISTS);

            sendEmailCandidate(email);

            ReferralsRecord ref = create.newRecord(REFERRALS);
            ref.setIdJobster(id_user);
            ref.setIdOffer(id_offer);
            ref.setDateCreation(Fechas.GetCurrentTimestampLong());
            ref.setCode(getRandomCodeOffer());
            ref.setEmailCandidate(email);
            ref.store();

            create.close();
            conn.close();
        }
        catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }

        return "OK";
    }

    private static boolean recomendationExist(DSLContext create, int id_offer, String email) {
        ReferralsRecord ref = create.select()
                .from(REFERRALS)
                .where(REFERRALS.ID_OFFER.equal(id_offer).and(REFERRALS.EMAIL_CANDIDATE.equal(email)))
                .fetchAnyInto(ReferralsRecord.class);

        return ref != null;
    }

    private static String getRandomCodeOffer() throws JobsterException{
        boolean validCode = false;
        String code = "";

        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            for(int i=0; i<Constantes.NUM_RANDOM_INTENTS_CODE_OFFER && !validCode; i++) {
                code = RandomString.generateCodeOffer(8);

                ReferralsRecord offer = create.select()
                        .from(REFERRALS)
                        .where(REFERRALS.CODE.equal(code))
                        .fetchAnyInto(ReferralsRecord.class);

                if (offer == null) validCode = true;
            }

            create.close();
            conn.close();
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
        return code;
    }

    private static void sendEmailCandidate(String email) {

    }
}
