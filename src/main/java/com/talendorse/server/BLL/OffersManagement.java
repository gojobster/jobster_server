package com.talendorse.server.BLL;

import com.talendorse.server.DTO.*;
import com.talendorse.server.POCO.Offer;
import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.tables.records.OffersRecord;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
import com.talendorse.server.types.OfferStatusType;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.model.Tables;
import org.jooq.*;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class OffersManagement {
    public static String addOffer(String position, String summary, int experience, String job_functions, String date_init, String date_end) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        OffersRecord offer = connection.create.newRecord(Tables.OFFERS);
        offer.setPosition(position);
        offer.setSummary(summary);
        offer.setExperience(experience);
        offer.setJobFunctions(job_functions);
        offer.setDateInit(Fechas.getCurrentTimestampLong());
        offer.setDateEnd(Fechas.getCurrentTimestampLong());

        offer.store();
        connection.closeConnection();
        return "OK";
    }

    public static List<RespuestaWSOffer> getAllWsOffers(String keyword) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getAllOffersByStatusRecord(connection.create, keyword, OfferStatusType.OPEN.toInt()));
        connection.closeConnection();
        return listOffers;
    }

    public static List<Offer> getAllOpenOffers(String keyword, String city) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<Offer> listOffers = getOffers(connection.create, getAllOffersByStatusRecord(connection.create, keyword, OfferStatusType.OPEN.toInt()));
        connection.closeConnection();
        return listOffers;
    }



    public static List<Offer> getAllOffers() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<Offer> listOffers = getOffers(connection.create, getAllOffersRecord(connection.create));
        connection.closeConnection();
        return listOffers;
    }

    public static List<RespuestaWSOffer> getAllFilteredOffers(String keyword, int salary, int experience, List<String> positions, List<String> cities, int pageSize, int numPage) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = new ArrayList<>();
        try {
            listOffers = getWSOffers(connection.create, getAllFilteredOffersRecord(connection.create, keyword,salary,experience,positions,cities, pageSize, numPage));
        } catch (TalendorseException e) {
            throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
        }
        connection.closeConnection();
        return listOffers;
    }

    private static List<OffersRecord> getAllFilteredOffersRecord(DSLContext create, String keyword, int salary, int experience, List<String> positions, List<String> cities, int pageSize, int numPage) throws TalendorseException {
        List<OffersRecord> lst = new ArrayList<>();

        try {
            SelectConditionStep<Record> newQuery = create.select().from(Tables.OFFERS)
                    .where(
                            (Tables.OFFERS.JOB_FUNCTIONS.contains(keyword).or(Tables.OFFERS.POSITION.contains(keyword)).or(Tables.OFFERS.SUMMARY.contains(keyword))
                                    .and(Tables.OFFERS.SALARY_MIN.ge(salary))
                                    .and(Tables.OFFERS.EXPERIENCE.le(experience))
                            ));
            if(!(cities.size() > 0 && cities.get(0).equals("")))
                newQuery.and(Tables.OFFERS.CITY.in(cities));
            if(!(positions.size() > 0 && positions.get(0).equals("")))
                newQuery.and(Tables.OFFERS.POSITION.in(positions));

            lst =  newQuery.limit(pageSize).offset(pageSize*numPage).fetchInto(OffersRecord.class);
//            lst = newQuery.fetchInto(OffersRecord.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TalendorseException(TalendorseErrorType.BD_ERROR);
        }
        return lst;
    }

    private static List<OffersRecord> getAllOffersByStatusRecord(DSLContext create, String Keyword, int status) {
        return create.select().from(Tables.OFFERS)
                .where(Tables.OFFERS.STATE.eq(OfferStatusType.OPEN.toInt())
                        .and(Tables.OFFERS.STATE.eq(status)
                                .and(Tables.OFFERS.JOB_FUNCTIONS.contains(Keyword))
                                .or(Tables.OFFERS.POSITION.contains(Keyword))
                                .or(Tables.OFFERS.SUMMARY.contains(Keyword))))
                .fetchInto(OffersRecord.class);
    }

    private static List<OffersRecord> getAllOpenRelatedOffersRecord(DSLContext create, int idOffer) {
        return create.select().from(Tables.OFFERS)
                .where(Tables.OFFERS.ID_OFFER.notEqual(idOffer)
                    .and(Tables.OFFERS.STATE.eq(OfferStatusType.OPEN.toInt())))
                .fetchInto(OffersRecord.class);
    }

    private static List<OffersRecord> getAllOffersRecord(DSLContext create) {
        return create.select().from(Tables.OFFERS).fetchInto(OffersRecord.class);
    }

    public static boolean offerExist(DSLContext create, int id_offer) {
        OffersRecord offer = create.select()
                .from(Tables.OFFERS)
                .where(Tables.OFFERS.ID_OFFER.equal(id_offer))
                .fetchAnyInto(OffersRecord.class);

        return offer != null;
    }

    public static List<String> getAllOffersCities() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        List<String> list = connection.create.selectDistinct(Tables.OFFERS.CITY).from(Tables.OFFERS).fetchInto(String.class);

        connection.closeConnection();
        return list;
    }

    public static List<RespuestaWSOffer> getUserOffers(String token) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getUserOffersRecord(connection.create, token));
        connection.closeConnection();
        return listOffers;
    }

    public static List<RespuestaWSMyOffer> getMyOffers(String token) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();
        int userId = UserManagement.GetUserIdfromToken(token);

        List<RespuestaWSMyOffer> listOffers = getWSMyOffers(connection.create,
                ReferralsManagement.getAllCandidateRefferralsByUserId(connection.create, userId));
        connection.closeConnection();

        return listOffers;
    }

    public static List<RespuestaWSMyEndorse> getUserMyEndorse(String token) throws TalendorseException{
        ConnectionBDManager connection = new ConnectionBDManager();
        int userId = UserManagement.GetUserIdfromToken(token);

        List<RespuestaWSMyEndorse> listOffers = getWSMyEndorse(connection.create,
                ReferralsManagement.getAllEndorserRefferralsByUserId(connection.create, userId));
        connection.closeConnection();

        return listOffers;
    }

    public static List<RespuestaWSOfferCity> getAllCities() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        List<RespuestaWSOfferCity> list = connection.create.select(Tables.OFFERS.CITY, count()).from(Tables.OFFERS).groupBy(Tables.OFFERS.CITY).fetchInto(RespuestaWSOfferCity.class);

        connection.closeConnection();
        return list;
    }

    public static List<RespuestaWSOffer> getTopOffers() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        List<OffersRecord> result = connection.create.select().from(Tables.OFFERS).orderBy(Tables.OFFERS.PRIORITY.desc()).limit(2).fetchInto(OffersRecord.class);
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, result);

        connection.closeConnection();
        return listOffers;
    }

    private static List<RespuestaWSOffer> getWSOffers(DSLContext create, List<OffersRecord> result) {
        List<RespuestaWSOffer> listOffers = new ArrayList<>();
        for (OffersRecord r : result) {
            CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, r.getValue(Tables.OFFERS.ID_COMPANY));

            RespuestaWSOffer offer = new RespuestaWSOffer (r.getIdOffer(),  company.getValue(Tables.COMPANIES.NAME),
                    company.getValue(Tables.COMPANIES.PATH_IMG), r.getPosition(), r.getSummary(),
                    r.getCity(),  r.getReward(), r.getSalaryMin(),
                    r.getSalaryMax(), r.getDateInit(), r.getDateEnd());
            listOffers.add(offer);
        }
        return listOffers;
    }

    private static List<RespuestaWSMyOffer> getWSMyOffers(DSLContext create, List<ReferralsRecord> result) {
        List<RespuestaWSMyOffer> listOffers = new ArrayList<>();
        try {
            for (ReferralsRecord referral : result) {
                Offer offer = OffersManagement.getOffer(create,referral.getValue(Tables.REFERRALS.ID_OFFER));
                UsersRecord endorser = UserManagement.getUser(referral.getValue(Tables.REFERRALS.ID_ENDORSER));

                RespuestaWSMyOffer respuestaOffer = new RespuestaWSMyOffer(offer.idOffer,  offer.nameCompany,
                        offer.path_image_company, offer.position, offer.summary,
                        offer.city,  offer.reward, offer.salary_min,
                        offer.salary_max, offer.date_ini, offer.date_end, endorser.getName() + " " +endorser.getSurname(), endorser.getPictureUrl(), endorser.getIdUser(), referral.getState());
                listOffers.add(respuestaOffer);
            }
        } catch (TalendorseException e) {
            e.printStackTrace();
            LogManagement.addLog("getWSMyOffers", e.toString());
        }
        return listOffers;
    }

    private static List<RespuestaWSMyEndorse> getWSMyEndorse(DSLContext create, List<ReferralsRecord> result) {
        List<RespuestaWSMyEndorse> listOffers = new ArrayList<>();
        try {
            for (ReferralsRecord referralRecord : result) {
                Offer offer = OffersManagement.getOffer(create, referralRecord.getValue(Tables.REFERRALS.ID_OFFER));

                Integer id_candidate = referralRecord.getValue(Tables.REFERRALS.ID_CANDIDATE);

                RespuestaWSMyEndorse myEndorse = null;
                if (id_candidate != null) {
                    UsersRecord candidate = UserManagement.getUser(id_candidate);

                    myEndorse = new RespuestaWSMyEndorse(offer.idOffer,  offer.nameCompany,
                            offer.path_image_company, offer.position, offer.summary,
                            offer.city,  offer.reward, offer.salary_min,
                            offer.salary_max, offer.date_ini, offer.date_end, candidate.getName() + " " +candidate.getSurname(), candidate.getPictureUrl(), referralRecord.getEmailCandidate(), candidate.getIdUser(), referralRecord.getState());
                }
                else {
                    myEndorse = new RespuestaWSMyEndorse(offer.idOffer,  offer.nameCompany,
                            offer.path_image_company, offer.position, offer.summary,
                            offer.city,  offer.reward, offer.salary_min,
                            offer.salary_max, offer.date_ini, offer.date_end, referralRecord.getNamecandidate(), "", referralRecord.getEmailCandidate(), -1, referralRecord.getState());
                }

                listOffers.add(myEndorse);
            }
        } catch (TalendorseException e) {
            e.printStackTrace();
            LogManagement.addLog("getWSMyEndorse", e.toString());
        }
        return listOffers;
    }

    public static RespuestaWSOfferFilters getAllOffersFilters(String Keyword) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        Result result = connection.create.select(min(Tables.OFFERS.SALARY_MIN), max(Tables.OFFERS.SALARY_MAX), max(Tables.OFFERS.EXPERIENCE)).from(Tables.OFFERS).fetch();

        List<String> list_studies = connection.create.selectDistinct(Tables.OFFERS.JOB_FUNCTIONS).from(Tables.OFFERS).where(Tables.OFFERS.JOB_FUNCTIONS.contains(Keyword).or(Tables.OFFERS.POSITION.contains(Keyword)).or(Tables.OFFERS.SUMMARY.contains(Keyword))).fetchInto(String.class);

        connection.closeConnection();

        List<RespuestaWSOfferCity> list_cities = getAllCities();

        return new RespuestaWSOfferFilters((Integer) result.getValues(0).get(0), (Integer) result.getValues(1).get(0),
                (Integer) result.getValues(2).get(0), list_studies, list_cities);

    }

    public static Offer getOffer(int idOffer) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        OffersRecord offerRecord = connection.create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.equal(idOffer)).fetchAnyInto(OffersRecord.class);
        CompaniesRecord company = CompaniesManagement.getCompanyRecord(connection.create, offerRecord.getValue(Tables.OFFERS.ID_COMPANY));

        int applications = ReferralsManagement.getApplicationsOffer(connection.create, idOffer);

        Offer offer = new Offer(offerRecord, company, applications);

        connection.closeConnection();
        return offer;
    }

    public static Offer getOffer(DSLContext create, int idOffer) throws TalendorseException {
        OffersRecord offer = create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.equal(idOffer)).fetchAnyInto(OffersRecord.class);
        CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, offer.getValue(Tables.OFFERS.ID_COMPANY));

        int applications = ReferralsManagement.getApplicationsOffer(create, idOffer);

        return new Offer(offer, company, applications);
    }

    private static List<Offer> getOffers(DSLContext create, List<OffersRecord> listOffersRecord) {
        List<Offer> listOffers = new ArrayList<>();
        for (OffersRecord offerRecord : listOffersRecord) {
            CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, offerRecord.getValue(Tables.OFFERS.ID_COMPANY));

            int applications = ReferralsManagement.getApplicationsOffer(create, offerRecord.getIdOffer());

            Offer offer = new Offer (offerRecord, company, applications);
            listOffers.add(offer);
        }
        return listOffers;
    }

    private static List<OffersRecord> getUserOffersRecord(DSLContext create, String token) throws TalendorseException{
        int idUser = create.select().from(Tables.TOKENS).where(Tables.TOKENS.TOKEN.contains(token)).fetchSingle(Tables.TOKENS.ID_USER);
        List<Integer> offers = create.select().from(Tables.REFERRALS).where(Tables.REFERRALS.ID_CANDIDATE.contains(idUser)).fetch(Tables.REFERRALS.ID_OFFER, Integer.class);
        return create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.in(offers)).fetchInto(OffersRecord.class);
    }

    private static List<OffersRecord> getUserEndorsementsOffersRecord(DSLContext create, int idUser) throws TalendorseException{
        List<Integer> offers = create.select().from(Tables.REFERRALS).where(Tables.REFERRALS.ID_ENDORSER.contains(idUser)).fetch(Tables.REFERRALS.ID_OFFER, Integer.class);
        return create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.in(offers)).fetchInto(OffersRecord.class);
    }

    public static boolean userApplied(int idOffer, Integer userId) throws TalendorseException{
        if(userId == null | userId == -1) return false;

        ConnectionBDManager connection = new ConnectionBDManager();

        ReferralsRecord ref = connection.create.select().from(Tables.REFERRALS)
                                .where(Tables.REFERRALS.ID_OFFER.eq(idOffer)
                                        .and(Tables.REFERRALS.ID_CANDIDATE.eq(userId)))
                                .fetchAnyInto(ReferralsRecord.class);
        connection.closeConnection();
        return ref != null;
    }


    public static String saveOffer(Integer id_offer, String position, String summary, String jobFunctions, String country, String city,
                                   Integer experience, Integer stateOffer, Integer workingDayType, Integer personasACargo, Integer priority,
                                   Integer maxSalary, Integer minSalary, Integer reward, String dateIni, String dateEnd) {
        try {
            ConnectionBDManager connection = new ConnectionBDManager();
            OffersRecord offer = null;

            if(id_offer == null)
                offer = connection.create.newRecord(Tables.OFFERS);
            else
                offer = connection.create
                                    .select()
                                    .from(Tables.OFFERS)
                                    .where(Tables.OFFERS.ID_OFFER.equal(id_offer))
                                    .fetchAnyInto(OffersRecord.class);

            offer.setPosition(position);
            offer.setSummary(summary);
            offer.setJobFunctions(jobFunctions);
            offer.setCountry(country);
            offer.setCity(city);
            offer.setExperience(experience);
            offer.setState(stateOffer);
            offer.setTipoJornada(workingDayType);
            offer.setPeopleInCharge(personasACargo);
            offer.setPriority(priority);
            offer.setSalaryMax(maxSalary);
            offer.setSalaryMin(minSalary);
            offer.setReward(reward);

            if (dateIni != null)
                offer.setDateInit(Fechas.getTimeStampgFromString(dateIni));

            if (dateEnd != null)
                offer.setDateEnd(Fechas.getTimeStampgFromString(dateEnd));

            offer.store();
            connection.closeConnection();
        } catch (TalendorseException e) {
            e.printStackTrace();
            return "KO";
        }

        return "OK";
    }

    public static List<Offer> getRelatedOffers(int idOffer) {
        List<Offer> listOffers = new ArrayList<>();
        try {
            ConnectionBDManager connection = new ConnectionBDManager();
            for (OffersRecord offerRecord : getAllOpenRelatedOffersRecord(connection.create, idOffer)) {
                CompaniesRecord company = CompaniesManagement.getCompanyRecord(connection.create, offerRecord.getValue(Tables.OFFERS.ID_COMPANY));
                int applications = ReferralsManagement.getApplicationsOffer(connection.create, offerRecord.getIdOffer());

                Offer offer = new Offer (offerRecord, company, applications);
                listOffers.add(offer);
            }
            connection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOffers;
    }
}