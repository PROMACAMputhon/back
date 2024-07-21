package com.dongguk.campton.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorDefine {
    TOO_MANY_REQUESTS("3000", HttpStatus.TOO_MANY_REQUESTS, "Too Many Requests: many request"),
    // Bad Request
    INVALID_ARGUMENT("4000", HttpStatus.BAD_REQUEST, "Bad Request: Invalid Arguments"),
    ALREADY_EXIST_MEMBER("4001", HttpStatus.BAD_REQUEST, "존재하는 아이디 입니다"),
    NOT_EXIST_MEMBER("4002", HttpStatus.BAD_REQUEST, "존재하지 않는 아이디 입니다"),
    WRONG_PASSWORD("4003", HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다"),

    // INTERNAL_SERER_ERROR: 500
    SERVER_ERROR("5000", HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 있습니다.");
    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;
}
