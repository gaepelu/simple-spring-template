package com.gaepelu.simplespringtemplate.exception;

import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;

@ResponseBody
public class InternalServerErrorException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public InternalServerErrorException(String message) {
        super(message, STATUS, Level.SEVERE);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause, STATUS, Level.SEVERE);
    }
}
