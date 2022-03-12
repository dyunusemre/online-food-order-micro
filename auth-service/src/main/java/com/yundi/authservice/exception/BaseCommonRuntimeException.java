package com.yundi.authservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCommonRuntimeException extends RuntimeException {
    private final ApiErrorCode apiErrorCode;
    private final String message;

    public BaseCommonRuntimeException(String message, ApiErrorCode apiErrorCode) {
        this.message = message;
        this.apiErrorCode = apiErrorCode;
    }
}
