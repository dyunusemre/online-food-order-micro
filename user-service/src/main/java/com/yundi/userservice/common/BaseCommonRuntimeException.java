package com.yundi.userservice.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCommonRuntimeException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseCommonRuntimeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
