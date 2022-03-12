package com.yundi.authservice.exception;

public class AlreadyExistsException extends BaseCommonRuntimeException {
    public AlreadyExistsException() {
        super("Already Exists", ApiErrorCode.CONFLICT);
    }
}
