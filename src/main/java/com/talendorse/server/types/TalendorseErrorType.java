package com.talendorse.server.types;

public enum TalendorseErrorType {

    GENERIC_ERROR(-1, "ERROR"),
    USER_ALREADY_EXISTS(-2, "USER ALREADY EXSISTS"),
    NOTIFICATION_NOT_FOUND(-3, "NOTIFICATION NOT FOUND"),
    CLOSE_BD_ERROR(-5, "ERROR"),
    NOT_ALLOWED(-6, "NOT ALLOWED"),
    ENCRYPTING_ERROR(-7, "ERROR"),
    USER_NOT_VALIDATED(-9, "EMAIL O TELEFONO NO VALIDADOS"),
    INVALID_PASSWORD_FORMAT(-300, "INVALID PASSWORD FORMAT"),
    INVALID_MAIL_FORMAT(-401, "INVALID MAIL FORMAT"),
    LOGIN_ERROR(-402, "ERROR LOGGING IN"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(-404, "NOT FOUND"),
    USER_NOT_FOUND(-409, "INVALID USER"),
    USER_NOT_VERIFIED(-410, "USER NOT VERIFIED"),
    TOKEN_NOT_FOUND(-411, "TOKEN ERROR"),
    CANDIDATE_NOT_FOUND(-412, "INVALID CANDIDATE"),
    INVALID_NAME(-500, "EMPTY NAME"),
    INVALID_SURNAME(-501, "EMPTY SURNAME"),
    PASSWORD_TOO_SHORT(-600, "PASSWORD TOO SHORT"),
    IDIOM_ALREADY_EXISTS(-700, "IDIOM ALREADY EXISTS"),
    SKILL_ALREADY_EXISTS(-800, "SKILL ALREADY EXISTS"),
    USER_NOT_EXISTS(-900, "USER NOT EXISTS"),
    OFFER_NOT_EXISTS(-901, "OFFER NOT EXISTS"),
    REFERRAL_EXISTS(-902, "REFERRAL EXISTS");


    private final int code;
    private final String description;

    TalendorseErrorType(int code, String description) {
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
