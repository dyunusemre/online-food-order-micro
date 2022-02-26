package com.yundi.userservice.exception;

import com.yundi.userservice.common.BaseCommonRuntimeException;
import com.yundi.userservice.common.ErrorCode;

public class InvalidRecaptchaException extends BaseCommonRuntimeException {

    public InvalidRecaptchaException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
