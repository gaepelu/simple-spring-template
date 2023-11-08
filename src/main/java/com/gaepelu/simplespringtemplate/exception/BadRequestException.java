package com.gaepelu.simplespringtemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Level;

@ResponseBody
public class BadRequestException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public BadRequestException(String message) {
        super(message, STATUS, Level.WARNING);
    }

}
