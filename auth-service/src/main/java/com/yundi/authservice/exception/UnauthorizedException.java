package com.yundi.authservice.exception;

public class UnauthorizedException extends BaseCommonRuntimeException {
    public UnauthorizedException() {
        super("Unauthorized", ApiErrorCode.UNAUTHORIZED);
    }
}
