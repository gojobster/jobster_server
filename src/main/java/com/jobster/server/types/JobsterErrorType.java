package com.jobster.server.types;

public enum JobsterErrorType {

    GENERIC_ERROR(-1, "ERROR"),
    USER_ALREADY_EXISTS(-2, "USER ALREADY EXSISTS"),
    NOTIFICATION_NOT_FOUND(-3, "NOTIFICATION NOT FOUND"),
    NOT_ALLOWED(-6, "NOT ALLOWED"),
    USER_NOT_VALIDATED(-9, "EMAIL O TELEFONO NO VALIDADOS"),
    INVALID_PASSWORD_FORMAT(-300, "INVALID PASSWORD FORMAT"),
    INVALID_MAIL_FORMAT(-401, "INVALID MAIL FORMAT"),
    LOGIN_ERROR(-402, "ERROR LOGGING IN"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(-404, "NOT FOUND"),
    USER_NOT_FOUND(-410, "INVALID USER"),
    INVALID_NAME(-500, "EMPTY NAME"),
    INVALID_SURNAME(-500, "EMPTY SURNAME"),
    PASSWORD_TOO_SHORT(-600, "PASSWORD TOO SHORT"),
    IDIOM_ALREADY_EXISTS(-700, "IDIOM ALREADY EXSISTS"),
    SKILL_ALREADY_EXISTS(-800, "SKILL ALREADY EXSISTS");


    private final int code;
    private final String description;

    JobsterErrorType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getMessage() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}