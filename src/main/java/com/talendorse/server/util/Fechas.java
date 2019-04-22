package com.talendorse.server.util;

import com.talendorse.server.BLL.Constantes;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class Fechas {
    public static Timestamp getCurrentTimestampLong() {
        return new Timestamp(new DateTime().getMillis() + TimeZone.getDefault().getRawOffset());
    }

    public static Timestamp getTokenExpiration() {
        Timestamp date = new Timestamp(new DateTime().getMillis() + TimeZone.getDefault().getRawOffset());
        return new Timestamp(date.getTime() + TimeUnit.SECONDS.toMillis(Constantes.TOKEN_EXPIRATION_MINUTES));
    }
}
