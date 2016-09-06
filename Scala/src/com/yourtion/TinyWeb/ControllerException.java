package com.yourtion.TinyWeb;

/**
 * Created by Yourtion on 9/5/16.
 */
public class ControllerException extends RuntimeException {

    private Integer statusCode;

    public ControllerException(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
