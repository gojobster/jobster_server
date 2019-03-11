package com.jobster.server.BLL;

import com.jobster.server.model.tables.records.IdiomsRecord;
import com.jobster.server.model.tables.records.UsersRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.Fechas;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jobster.server.model.Tables.IDIOMS;
import static com.jobster.server.model.Tables.USERS;

public class IdiomsManagement {
    public static String addIdiom(String idiomName) throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            idiomName = idiomName.trim();

            IdiomsRecord idiom = create.select()
                    .from(IDIOMS)
                    .where(IDIOMS.NAME.equal(idiomName))
                    .fetchAnyInto(IdiomsRecord.class);
            if (idiom != null) throw new JobsterException(JobsterErrorType.IDIOM_ALREADY_EXISTS);

            idiom = create.newRecord(IDIOMS);
            idiom.setName(idiomName);
            idiom.setDateCreated(Fechas.GetCurrentTimestampLong());

            idiom.store();
            create.close();
            conn.close();
        }
        catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
        return "OK";
    }
}
