package com.talendorse.server.types;

public enum StatusType {
    CANCELLED(-1),
    PENDING(0),
    IN_PROGRESS(1),
    PRESELECTED(2),
    HIRED(3),
    REJECTED(4);

    private final int code;

    StatusType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
