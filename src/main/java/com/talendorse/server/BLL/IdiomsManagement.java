package com.talendorse.server.BLL;

import com.talendorse.server.model.tables.records.IdiomsRecord;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.model.Tables;

public class IdiomsManagement {
    public static String addIdiom(String idiomName) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        idiomName = idiomName.trim();

        IdiomsRecord idiom = connection.create.select()
                .from(Tables.IDIOMS)
                .where(Tables.IDIOMS.NAME.equal(idiomName))
                .fetchAnyInto(IdiomsRecord.class);
        if (idiom != null) throw new TalendorseException(TalendorseErrorType.IDIOM_ALREADY_EXISTS);

        idiom = connection.create.newRecord(Tables.IDIOMS);
        idiom.setName(idiomName);

        idiom.store();
        connection.closeConnection();
        return "OK";
    }
}
