package com.talendorse.server.types;

public enum ContractType {

    INDEFINITE(0),
    TEMPORAL(1),
    TRAINING(2);

    private final int code;

    ContractType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}