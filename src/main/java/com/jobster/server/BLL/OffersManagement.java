package com.jobster.server.BLL;

import com.jobster.server.DTO.RespuestaWSOffer;
import com.jobster.server.DTO.RespuestaWSUser;
import com.jobster.server.model.tables.Companies;
import com.jobster.server.model.tables.records.CompaniesRecord;
import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.Fechas;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jobster.server.model.Tables.*;

public class OffersManagement {
    public static String addOffer(String position, String summary, int experience, String job_functions, String date_init, String date_end) throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            OffersRecord offer = create.newRecord(OFFERS);
            offer.setPosition(position);
            offer.setSummary(summary);
            offer.setExperience(experience);
            offer.setJobFunctions(job_functions);
            offer.setDateInit(Fechas.GetCurrentTimestampLong());
            offer.setDateEnd(Fechas.GetCurrentTimestampLong());

            offer.store();
            create.close();
            conn.close();
        }
        catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
        return "OK";
    }

    public static List<RespuestaWSOffer> getAllOffers(String keyword, String city) throws JobsterException{
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);


            Result<Record> result = create.select().from(OFFERS)
                    .where(OFFERS.POSITION.contains(keyword).and(OFFERS.CITY.contains(city))).fetch();

            List<RespuestaWSOffer> listOffers = new ArrayList<>();
            for (Record r : result) {
                CompaniesRecord company = CompaniesManagement.getCompanyRecord(create, r.getValue(OFFERS.ID_COMPANY));

                RespuestaWSOffer offer = new RespuestaWSOffer (r.getValue(OFFERS.ID_OFFER), company.getValue(COMPANIES.NAME),
                        company.getValue(COMPANIES.PATH_IMG), r.getValue(OFFERS.POSITION), r.getValue(OFFERS.SUMMARY),
                        r.getValue(OFFERS.CITY),  r.getValue(OFFERS.REWARD), r.getValue(OFFERS.SALARY_MIN),
                        r.getValue(OFFERS.SALARY_MAX), r.getValue(OFFERS.DATE_INIT), r.getValue(OFFERS.DATE_INIT));
                listOffers.add(offer);
            }

            conn.close();
            create.close();
            return listOffers;
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
    }

    public static boolean offerExist(DSLContext create, int id_offer) {
        OffersRecord offer = create.select()
                .from(OFFERS)
                .where(OFFERS.ID_OFFER.equal(id_offer))
                .fetchAnyInto(OffersRecord.class);

        return offer != null;
    }
}