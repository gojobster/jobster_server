package com.talendorse.server.BLL;

import com.talendorse.server.types.TalendorseErrorType;

public class TalendorseException extends Exception {

    private static final long serialVersionUID = 1L;
    private int _errorNumber;

    public TalendorseException() {

    }

    public TalendorseException(String message) {

        super(message);
    }

    public TalendorseException(TalendorseErrorType error) {
        super(error.getMessage());
        this._errorNumber = error.getCode();
    }

    public TalendorseException(String message, int ErrorNumber) {
        super(message);
        this._errorNumber = ErrorNumber;

    }

    public int getErrorNumber() {
        return _errorNumber;
    }

    public void setErrorNumber(int value) {
        _errorNumber = value;
    }
}
