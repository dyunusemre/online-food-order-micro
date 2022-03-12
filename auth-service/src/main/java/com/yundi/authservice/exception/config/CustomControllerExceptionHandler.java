package com.yundi.authservice.exception.config;

import com.yundi.authservice.exception.BaseCommonRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomControllerExceptionHandler {

    @ExceptionHandler(BaseCommonRuntimeException.class)
    ResponseEntity<Object> handleBaseRuntimeException(BaseCommonRuntimeException exception) {
        //TODO exception needs refactoring
        return ResponseEntity.status(exception.getApiErrorCode().getHttpStatus()).body(exception.getMessage());
    }
}
