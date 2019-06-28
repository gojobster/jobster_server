package com.talendorse.server.BLL;

import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.types.StatusType;
import org.jooq.DSLContext;

import java.util.List;

public class ReferralsManagement {
    public static ReferralsRecord getReferralsRecord(DSLContext create, int id_referral) {
        return create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_REFERRAL.equal(id_referral))
                .fetchAnyInto(ReferralsRecord.class);
    }

    public static List<ReferralsRecord> getAllEndorserRefferralsByUserId (DSLContext create, int userId) {
        return create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_ENDORSER.equal(userId)).fetchInto(ReferralsRecord.class);
    }

    public static List<ReferralsRecord> getAllCandidateRefferralsByUserId (DSLContext create, int userId) {
        return create.select()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_CANDIDATE.equal(userId)).fetchInto(ReferralsRecord.class);
    }

    public static int getApplicationsOffer(DSLContext create, int idOffer) {
        return create.selectCount()
                .from(Tables.REFERRALS)
                .where(Tables.REFERRALS.ID_OFFER.equal(idOffer)
                        .and(Tables.REFERRALS.STATE.eq(StatusType.IN_PROGRESS.toInt())
                        .or(Tables.REFERRALS.STATE.eq(StatusType.PRESELECTED.toInt()))
                        .or(Tables.REFERRALS.STATE.eq(StatusType.HIRED.toInt())))).fetchOne(0, int.class);
    }


//    public static Company getReferral(int id_referral) {
//        try {
//            ConnectionBDManager connection = new ConnectionBDManager();
//            ReferralsRecord company = connection.create.select()
//                                        .from(Tables.COMPANIES)
//                                        .where(Tables.COMPANIES.ID_COMPANY.equal(id_company))
//                                        .fetchAnyInto(CompaniesRecord.class);
//
//            String countryName = connection.create.select(Tables.COUNTRIES.NAME_ES).from(Tables.COUNTRIES).where(Tables.COUNTRIES.ID_COUNTRY.equal(company.getIdCountry())).fetchAnyInto(String.class);
//            connection.closeConnection();
//
//            return new Company(company, countryName);
//
//        } catch (TalendorseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
