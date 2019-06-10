package com.talendorse.server.BLL;

import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.LogsRecord;


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