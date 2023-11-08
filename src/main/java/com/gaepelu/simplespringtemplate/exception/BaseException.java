package com.gaepelu.simplespringtemplate.exception;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;

@JsonIncludeProperties({"status", "message", "timestamp"})
public class BaseException extends RuntimeException {

    private final Date timestamp;

    private final HttpStatus httpStatus;

    private final Level logLevel;

    public BaseException(String message, HttpStatus httpStatus, Level logLevel) {
        super(message);
        this.httpStatus = Optional.ofNullable(httpStatus).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        this.logLevel = logLevel;
        this.timestamp = new Date();
    }

    public BaseException(String message, Throwable throwable, HttpStatus httpStatus, Level logLevel) {
        super(message, throwable);
        this.httpStatus = Optional.ofNullable(httpStatus).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        this.logLevel = logLevel;
        this.timestamp = new Date();
    }

    public int getStatus() {
        return httpStatus.value();
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
