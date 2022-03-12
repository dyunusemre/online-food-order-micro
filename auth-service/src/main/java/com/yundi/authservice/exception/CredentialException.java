package com.yundi.authservice.exception;

public class CredentialException extends BaseCommonRuntimeException {
    public CredentialException() {
        super("Wrong username or password", ApiErrorCode.FORBIDDEN);
    }
}
