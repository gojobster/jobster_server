package com.jobster.server.BLL;

import com.jobster.server.DTO.RespuestaWSOffer;
import com.jobster.server.DTO.RespuestaWSOfferCity;
import com.jobster.server.DTO.RespuestaWSOfferFilters;
import com.jobster.server.POCO.Offer;
import com.jobster.server.model.tables.records.CompaniesRecord;
import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.util.Fechas;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;

import static com.jobster.server.model.Tables.*;
import static org.jooq.impl.DSL.*;

public class OffersManagement {
    public static String addOffer(String position, String summary, int experience, String job_functions, String date_init, String date_end) throws JobsterException {
        ConnectionBDManager connection = new ConnectionBDManager();

        OffersRecord offer = connection.create.newRecord(OFFERS);
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

    public static List<RespuestaWSOffer> getAllWsOffers(String keyword) throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getAllOffersRecord(connection.create, keyword));
        connection.closeConnection();
        return listOffers;
    }

    public static List<Offer> getAllOffers(String keyword, String city) throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();
        List<Offer> listOffers = getOffers(connection.create, getAllOffersRecord(connection.create, keyword));
        connection.closeConnection();
        return listOffers;
    }
    public static List<RespuestaWSOffer> getAllFilteredOffers(String keyword, String salary, String experience, List<String> positions, List<String> cities) throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, getAllFilteredOffersRecord(connection.create, keyword,salary,experience,positions,cities));
        connection.closeConnection();
        return listOffers;
    }

    private static List<OffersRecord> getAllFilteredOffersRecord(DSLContext create, String Keyword, String Salary, String Experience, List<String> Positions, List<String> Cities) throws JobsterException{
        return create.select().from(OFFERS)
                .where(
                        (OFFERS.JOB_FUNCTIONS.contains(Keyword).or(OFFERS.POSITION.contains(Keyword)).or(OFFERS.SUMMARY.contains(Keyword))
                        .and(OFFERS.SALARY_MIN.ge(Integer.parseInt(Salary)))
                        .and(OFFERS.EXPERIENCE.le(Integer.parseInt(Experience)))
                        .and(OFFERS.CITY.in(Cities))
                        .and(OFFERS.POSITION.in(Positions))
                        )).fetchInto(OffersRecord.class);
    }

    private static List<OffersRecord> getAllOffersRecord(DSLContext create, String Keyword) throws JobsterException{
        return create.select().from(OFFERS)
                .where(OFFERS.JOB_FUNCTIONS.contains(Keyword).or(OFFERS.POSITION.contains(Keyword)).or(OFFERS.SUMMARY.contains(Keyword))).fetchInto(OffersRecord.class);
    }

    public static boolean offerExist(DSLContext create, int id_offer) {
        OffersRecord offer = create.select()
                .from(OFFERS)
                .where(OFFERS.ID_OFFER.equal(id_offer))
                .fetchAnyInto(OffersRecord.class);

        return offer != null;
    }

    public static List<String> getAllOffersCities() throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();

        List<String> list = connection.create.selectDistinct(OFFERS.CITY).from(OFFERS).fetchInto(String.class);

        connection.closeConnection();
        return list;
    }

    public static List<RespuestaWSOfferCity> getAllCities() throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();

        List<RespuestaWSOfferCity> list = connection.create.select(OFFERS.CITY, count()).from(OFFERS).groupBy(OFFERS.CITY).fetchInto(RespuestaWSOfferCity.class);

        connection.closeConnection();
        return list;
    }

    public static List<RespuestaWSOffer> getTopOffers() throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();

        List<OffersRecord> result = connection.create.select().from(OFFERS).orderBy(OFFERS.PRIORITY.desc()).limit(2).fetchInto(OffersRecord.class);
        List<RespuestaWSOffer> listOffers = getWSOffers(connection.create, result);

        connection.closeConnection();
        return listOffers;
    }

    private static List<RespuestaWSOffer> getWSOffers(DSLContext create, List<OffersRecord> result) {
        List<RespuestaWSOffer> listOffers = new ArrayList<>();
        for (OffersRecord r : result) {
            CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, r.getValue(OFFERS.ID_COMPANY));

            RespuestaWSOffer offer = new RespuestaWSOffer (r.getIdOffer(),  company.getValue(COMPANIES.NAME),
                    company.getValue(COMPANIES.PATH_IMG), r.getPosition(), r.getSummary(),
                    r.getCity(),  r.getReward(), r.getSalaryMin(),
                    r.getSalaryMax(), r.getDateInit(), r.getDateEnd());
            listOffers.add(offer);
        }
        return listOffers;
    }

    public static RespuestaWSOfferFilters getAllOffersFilters(String Keyword) throws JobsterException{
        ConnectionBDManager connection = new ConnectionBDManager();

        Result result = connection.create.select(min(OFFERS.SALARY_MIN), max(OFFERS.SALARY_MAX), max(OFFERS.EXPERIENCE)).from(OFFERS).fetch();

        List<String> list_studies = connection.create.selectDistinct(OFFERS.JOB_FUNCTIONS).from(OFFERS).where(OFFERS.JOB_FUNCTIONS.contains(Keyword).or(OFFERS.POSITION.contains(Keyword)).or(OFFERS.SUMMARY.contains(Keyword))).fetchInto(String.class);

        connection.closeConnection();

        List<RespuestaWSOfferCity> list_cities = getAllCities();

        return new RespuestaWSOfferFilters((Integer) result.getValues(0).get(0), (Integer) result.getValues(1).get(0),
                (Integer) result.getValues(2).get(0), list_studies, list_cities);

    }

    public static Offer getOffer(int id) throws JobsterException {
        ConnectionBDManager connection = new ConnectionBDManager();

        OffersRecord offer = connection.create.select().from(OFFERS).where(OFFERS.ID_OFFER.equal(id)).fetchAnyInto(OffersRecord.class);
        CompaniesRecord company = CompaniesManagement.getCompanyRecord(connection.create, offer.getValue(OFFERS.ID_COMPANY));

        return new Offer(offer, company);
    }

    private static List<Offer> getOffers(DSLContext create, List<OffersRecord> listOffersRecord) {
        List<Offer> listOffers = new ArrayList<>();
        for (OffersRecord offerRecord : listOffersRecord) {
            CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, offerRecord.getValue(OFFERS.ID_COMPANY));

            Offer offer = new Offer (offerRecord, company);
            listOffers.add(offer);
        }
        return listOffers;
    }
}