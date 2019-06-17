package com.talendorse.server.BLL;

import com.talendorse.server.DTO.*;
import com.talendorse.server.POCO.Offer;
import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.tables.records.OffersRecord;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
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
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getAllOffersRecord(connection.create, keyword));
        connection.closeConnection();
        return listOffers;
    }

    public static List<Offer> getAllOffers(String keyword, String city) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<Offer> listOffers = getOffers(connection.create, getAllOffersRecord(connection.create, keyword));
        connection.closeConnection();
        return listOffers;
    }
    public static List<RespuestaWSOffer> getAllFilteredOffers(String keyword, int salary, int experience, List<String> positions, List<String> cities) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getAllFilteredOffersRecord(connection.create, keyword,salary,experience,positions,cities));
        connection.closeConnection();
        return listOffers;
    }

    private static List<OffersRecord> getAllFilteredOffersRecord(DSLContext create, String keyword, int salary, int experience, List<String> positions, List<String> cities) throws TalendorseException {

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

        return newQuery.fetchInto(OffersRecord.class);
    }


    private static List<OffersRecord> getAllOffersRecord(DSLContext create, String Keyword) throws TalendorseException {
        return create.select().from(Tables.OFFERS)
                .where(Tables.OFFERS.JOB_FUNCTIONS.contains(Keyword).or(Tables.OFFERS.POSITION.contains(Keyword)).or(Tables.OFFERS.SUMMARY.contains(Keyword))).fetchInto(OffersRecord.class);
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

    public static Offer getOffer(int id) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        OffersRecord offerRecord = connection.create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.equal(id)).fetchAnyInto(OffersRecord.class);
        CompaniesRecord company = CompaniesManagement.getCompanyRecord(connection.create, offerRecord.getValue(Tables.OFFERS.ID_COMPANY));
        Offer offer = new Offer(offerRecord, company);

        connection.closeConnection();
        return offer;
    }

    public static Offer getOffer(DSLContext create, int id) throws TalendorseException {
        OffersRecord offer = create.select().from(Tables.OFFERS).where(Tables.OFFERS.ID_OFFER.equal(id)).fetchAnyInto(OffersRecord.class);
        CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, offer.getValue(Tables.OFFERS.ID_COMPANY));

        return new Offer(offer, company);
    }

    private static List<Offer> getOffers(DSLContext create, List<OffersRecord> listOffersRecord) {
        List<Offer> listOffers = new ArrayList<>();
        for (OffersRecord offerRecord : listOffersRecord) {
            CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, offerRecord.getValue(Tables.OFFERS.ID_COMPANY));

            Offer offer = new Offer (offerRecord, company);
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
        if(userId == null) return false;

        ConnectionBDManager connection = new ConnectionBDManager();

        ReferralsRecord ref = connection.create.select().from(Tables.REFERRALS)
                                .where(Tables.REFERRALS.ID_OFFER.eq(idOffer)
                                        .and(Tables.REFERRALS.ID_CANDIDATE.eq(userId)))
                                .fetchAnyInto(ReferralsRecord.class);
        return ref != null;
    }
}