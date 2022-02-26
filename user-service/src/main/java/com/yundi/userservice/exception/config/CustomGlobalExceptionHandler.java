package com.yundi.userservice.exception.config;

import com.yundi.userservice.common.BaseCommonRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(BaseCommonRuntimeException.class)
    ResponseEntity handleException(BaseCommonRuntimeException ex) {
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(ex.getMessage());
    }
}
