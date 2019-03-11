package com.jobster.server.BLL;

import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.Fechas;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jobster.server.model.Tables.OFFERS;

public class OffersManagement {
    public static String addOffer(String position, String summary, String experience, String job_functions, String date_init, String date_end) throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            OffersRecord offer = create.newRecord(OFFERS);
            offer.setPosition(position);
            offer.setSummary(summary);
            offer.setExperience(experience);
            offer.setJobFunctions(job_functions);
            offer.setDateCreated(Fechas.GetCurrentTimestampLong());
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
}
