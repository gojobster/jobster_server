package com.talendorse.server.BLL;

import com.talendorse.server.model.tables.records.LanguagesRecord;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.model.Tables;

public class LanguagesManagement {
    public static String addIdiom(String languageName) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        languageName = languageName.trim();

        LanguagesRecord language = connection.create.select()
                .from(Tables.LANGUAGES)
                .where(Tables.LANGUAGES.NAME.equal(languageName))
                .fetchAnyInto(LanguagesRecord.class);
        if (language != null) throw new TalendorseException(TalendorseErrorType.IDIOM_ALREADY_EXISTS);

        language = connection.create.newRecord(Tables.LANGUAGES);
        language.setName(languageName);

        language.store();
        connection.closeConnection();
        return "OK";
    }
}
