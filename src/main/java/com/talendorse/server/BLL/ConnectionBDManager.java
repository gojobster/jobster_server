package com.talendorse.server.BLL;

import com.talendorse.server.types.TalendorseErrorType;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDManager {
    private final static String TAG = ConnectionBDManager.class.getName();

    private Connection conn;
    public DSLContext create;

    public ConnectionBDManager() throws TalendorseException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            create = DSL.using(conn, SQLDialect.MYSQL);
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            LogManagement.addLog(TAG,""+ex.getMessage());
            throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
        }
    }

    public void closeConnection() throws TalendorseException {
        try {
            conn.close();
            create.close();
        } catch (SQLException e) {
            LogManagement.addLog(TAG,""+e.getMessage());
            throw new TalendorseException(TalendorseErrorType.CLOSE_BD_ERROR);
        }
    }
}
