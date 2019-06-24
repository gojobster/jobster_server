package com.talendorse.server.util;

import com.talendorse.server.BLL.Constantes;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
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

    public static String getDateStringFromTimeStamp(Timestamp timestamp) {
        return new SimpleDateFormat("dd/MM/yyyy").format(timestamp);
    }

    public static Timestamp getTimeStampgFromString(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = dateFormat.parse(dateString);
            return new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) { //this generic but you can control another types of exception
            return null;
        }
    }

    public static Integer daysFromNow(Timestamp myDate){
        LocalDate now = LocalDate.now();
        LocalDate theDate = myDate.toLocalDateTime().toLocalDate();
        Period period = Period.between(theDate, now);
        return Math.abs(period.getDays());
    }
}
