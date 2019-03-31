package com.jobster.server.util;

import com.jobster.server.types.ContratoType;
import com.jobster.server.types.JornadaType;

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
}
