package com.talendorse.server.types;

public enum ContratoType {

    INDEFINIDO(0),
    TEMPORAL(1),
    FORMACION(2);

    private final int code;

    ContratoType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
