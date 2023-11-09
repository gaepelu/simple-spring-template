package com.gaepelu.simplespringtemplate.controller.advice;


import com.gaepelu.simplespringtemplate.exception.BaseException;
import com.gaepelu.simplespringtemplate.exception.InternalServerErrorException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<BaseException> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException o) {
        BindingResult bindingResult = o.getBindingResult();
        String defaultMessage = Optional.ofNullable(bindingResult.getGlobalError())
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElseGet(() -> bindingResult.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", ")));
        String[] messageSplitted = defaultMessage
                .split(",");
        int status = Arrays.stream(messageSplitted)
                .map(m->m.split("#"))
                .mapToInt(m-> Arrays.stream(m).findFirst().filter(StringUtils::isNumeric).map(Integer::parseInt).orElse(400))
                .min()
                .orElse(400);

        BaseException baseException = new BaseException(defaultMessage, o, HttpStatus.resolve(status), Level.WARNING);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<BaseException> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException httpMessageNotReadableException) {
        BaseException baseException = new BaseException(httpMessageNotReadableException.getMessage(), httpMessageNotReadableException, HttpStatus.BAD_REQUEST, Level.WARNING);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    @ResponseBody
    public ResponseEntity<BaseException> httpMediaTypeExceptionHandler(HttpMediaTypeException httpMediaTypeException) {
        BaseException baseException = new BaseException(httpMediaTypeException.getMessage(), httpMediaTypeException, HttpStatus.BAD_REQUEST, Level.WARNING);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<BaseException> exceptionExceptionHandler(ConstraintViolationException o) {
        BaseException baseException = new BaseException(o.getMessage(), o, HttpStatus.BAD_REQUEST, Level.WARNING);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResponseEntity<BaseException> accessDeniedException(AccessDeniedException accessDeniedException) {
        BaseException baseException = new BaseException(accessDeniedException.getMessage(), accessDeniedException, HttpStatus.UNAUTHORIZED, Level.WARNING);
        log.log(baseException.getLogLevel(), baseException.getMessage(), baseException.getCause());
        return ResponseEntity.status(baseException.getStatus()).body(baseException);
    }
}
