package com.talendorse.server.types;

public enum StatusType {
    CANCELLED(-1),
    PENDING(0),
    JOINED(1),
    PRESELECTED(2),
    ACCEPTED(3);

    private final int code;

    StatusType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
