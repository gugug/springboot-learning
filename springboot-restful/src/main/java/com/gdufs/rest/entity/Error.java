package com.gdufs.rest.entity;

/**
 * @author gucailiang
 * @date 2018/10/10
 */
public class Error {
    private int code;
    private String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
