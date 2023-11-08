package com.gaepelu.simplespringtemplate.controller.advice;


import com.gaepelu.simplespringtemplate.exception.BaseException;
import com.gaepelu.simplespringtemplate.exception.InternalServerErrorException;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseException> baseException(BaseException baseException) {
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseException> exception(Exception exception) {
        BaseException baseException = new InternalServerErrorException(exception.getMessage(), exception);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }
}
