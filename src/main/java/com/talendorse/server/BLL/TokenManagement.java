package com.talendorse.server.BLL;

import com.talendorse.server.model.Tables;
import com.talendorse.server.model.tables.records.TokensRecord;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.util.Fechas;
import com.talendorse.server.util.Util;

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
    public static boolean isTokenValid(String token) throws TalendorseException {
        boolean tokenExists = false;

        ConnectionBDManager connection = new ConnectionBDManager();

        TokensRecord t =    connection.create.select()
                .from(Tables.TOKENS)
                .where(Tables.TOKENS.TOKEN.equal(token).and(Tables.TOKENS.EXPIRATION_DATE.greaterThan(Fechas.getCurrentTimestampLong())))
                .fetchAnyInto(TokensRecord.class);

        if (t!=null)
            tokenExists = true;

        connection.closeConnection();

        return  tokenExists;
    }
    public static boolean isTokenValid(String token, int id) throws TalendorseException {

        boolean tokenExists = false;

        ConnectionBDManager connection = new ConnectionBDManager();

        TokensRecord t = connection.create.select().from(Tables.TOKENS).where(Tables.TOKENS.TOKEN.equal(token).and(Tables.TOKENS.ID_USER.equal(id)).and(Tables.TOKENS.EXPIRATION_DATE.greaterThan(Fechas.getCurrentTimestampLong()))).fetchAnyInto(TokensRecord.class);

        if (t!=null)
            tokenExists = true;

        connection.closeConnection();

        return  tokenExists;
    }
    public static int getUserIdFromToken(String token) throws TalendorseException {

        ConnectionBDManager connection = new ConnectionBDManager();

        Integer id = connection.create.select().from(Tables.TOKENS).where(Tables.TOKENS.TOKEN.equal(token).and(Tables.TOKENS.EXPIRATION_DATE.greaterThan(Fechas.getCurrentTimestampLong()))).fetchSingle(Tables.TOKENS.ID_USER);

        connection.closeConnection();

        return  id == null ? -1 : id;
    }
}
