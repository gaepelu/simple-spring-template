package com.gaepelu.simplespringtemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Level;

@ResponseBody
public class NotFoundException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(message, STATUS, Level.WARNING);
    }

}
