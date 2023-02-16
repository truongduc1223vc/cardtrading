package com.magellans.cardtrading.exception;


import com.magellans.cardtrading.common.MsgsResource;

public class BEException extends Exception {
    private String code;
    private String message;

    public BEException(String code) {
        super();
        this.code = code;
        this.message = MsgsResource.getI18N(code);
    }

    public BEException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}