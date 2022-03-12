package com.yundi.authservice.exception;

public class TokenException extends BaseCommonRuntimeException {
    public TokenException() {
        super("Token is missing", ApiErrorCode.FORBIDDEN);
    }
}
