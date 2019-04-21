package com.jobster.server.util;

import com.jobster.server.BLL.JobsterException;
import com.jobster.server.BLL.UserManagement;
import com.jobster.server.types.ContratoType;
import com.jobster.server.types.JornadaType;

import javax.ws.rs.core.HttpHeaders;
import java.util.UUID;

public class Util {
    public static String getContractTypeString (int type) {
        String contractType = "";

        if (type == ContratoType.INDEFINIDO.toInt())
            contractType = "Indefinifo";
        else if (type == ContratoType.TEMPORAL.toInt())
            contractType = "Temporal";
        else if (type == ContratoType.FORMACION.toInt())
            contractType = "Formacion";

        return contractType;
    }

    public static String getJornadaTypeString (int type) {
        String jornadaType = "";

        if (type == JornadaType.COMPLETA.toInt())
            jornadaType = "Full time";
        else if (type == JornadaType.PARCIAL.toInt())
            jornadaType = "Partial time";
        else if (type == JornadaType.MANANA.toInt())
            jornadaType = "Morning";
        else if (type == JornadaType.TARDE.toInt())
            jornadaType = "Afternoon";
        else if (type == JornadaType.PORHORAS.toInt())
            jornadaType = "Per hours";

        return jornadaType;
    }

    public static String getNewToken() {
        String token = UUID.randomUUID().toString();
        return token.replace("-","");
    }

    public static void check_token(HttpHeaders httpheaders) throws JobsterException {
        String token = httpheaders.getHeaderString("Authorization");
        UserManagement.check_token(token);
    }
}
