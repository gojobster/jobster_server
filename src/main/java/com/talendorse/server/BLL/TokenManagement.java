package com.talendorse.server.BLL;

import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.LanguagesRecord;
import com.talendorse.server.model.tables.records.TokensRecord;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.util.Util;

import java.sql.Timestamp;

public class TokenManagement {
    public static TokensRecord addToken(int idUser) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        if (!UserManagement.userExist(connection.create, idUser)) throw new TalendorseException(TalendorseErrorType.USER_NOT_FOUND);

        TokensRecord token = connection.create.newRecord(Tables.TOKENS);
        token.setIdUser(idUser);
        token.setToken(Util.getNewToken());
        token.setExpirationDate(Fechas.getTokenExpiration());
        token.store();
        connection.closeConnection();

        return token;
    }
}
