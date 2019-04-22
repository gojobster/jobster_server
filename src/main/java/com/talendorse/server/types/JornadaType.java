package com.talendorse.server.types;

public enum JornadaType {

    COMPLETA(0),
    PARCIAL(1),
    MANANA(2),
    TARDE(3),
    PORHORAS(4);

    private final int code;

    JornadaType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
