package com.talendorse.server.types;

public enum OfferStatusType {

    INACTIVE(0),
    OPEN(1),
    CLOSED(2);

    private final int code;

    OfferStatusType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}