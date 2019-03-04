package com.jobster.server.rest;

import com.jobster.server.BLL.Constantes;
import com.jobster.server.model.tables.Users;
import com.jobster.server.model.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jobster.server.model.Tables.USERS;

@Path("/")
public class HelloRestService {
    @GET // This annotation indicates GET request
    @Path("/hello")
    public Response hello() {
        return Response.status(200).entity("Hello Jobster").build();
    }

    @GET
    @Path("/jobster")
    public Response jobster() {
        String result = "";

        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            UsersRecord user = create.select()
                    .from(USERS).where(USERS.ID_USERS.equal(1)).fetchAnyInto(UsersRecord.class);

            result = user.getName();
        } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (result.equals(""))
            result = "No hay usuarios";

        return Response.status(200).entity(result).build();
    }
}
