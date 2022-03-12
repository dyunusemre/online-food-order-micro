package com.yundi.authservice.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiErrorCode {
    INTERNAL_ERROR("1",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("2", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("3", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("4", HttpStatus.FORBIDDEN),
    CONFLICT("4", HttpStatus.CONFLICT);

    private final String code;
    private final HttpStatus httpStatus;
}
