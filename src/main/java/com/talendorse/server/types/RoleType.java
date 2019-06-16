package com.talendorse.server.types;

public enum RoleType {
    ENDORSER(0),
    COMPANY(1),
    ADMIN(2);

    private final int code;

    RoleType(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
