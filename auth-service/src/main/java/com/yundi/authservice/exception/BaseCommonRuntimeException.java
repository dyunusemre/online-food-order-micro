package com.yundi.authservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCommonRuntimeException extends RuntimeException {
    private final ApiErrorCode apiErrorCode;

    public BaseCommonRuntimeException(String message, ApiErrorCode apiErrorCode) {
        super(message);
        this.apiErrorCode = apiErrorCode;
    }
}
