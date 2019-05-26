package com.talendorse.server.BLL;

import com.talendorse.server.model.Keys;
import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.LogsRecord;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
import com.talendorse.server.types.StatusType;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.Email;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.util.RandomString;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;

import java.util.logging.LogRecord;

public class LogManagement {
    public static void addLog (String TAG, String log_string) {
        try {
            ConnectionBDManager connection = new ConnectionBDManager();
            LogsRecord log = connection.create.newRecord(Tables.LOGS);
            log.setTag(TAG);
            log.setLog(log_string);
            log.store();
            connection.closeConnection();
        } catch (TalendorseException e) {
            e.printStackTrace();
        }
    }
}
