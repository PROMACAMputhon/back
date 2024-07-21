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
    NOT_END_POINT("4001",HttpStatus.BAD_REQUEST , "Bad Request: Not Exist End Point Error"),
    OVER_ITEM_AMOUNT("4002", HttpStatus.BAD_REQUEST, "Bad Request: Over Item Amount"),
    // UNAUTHORIZED: 401
    ACCESS_DENIED("4010", HttpStatus.UNAUTHORIZED, "Unauthorized: Access denied"),
    TOKEN_INVALID("4011", HttpStatus.UNAUTHORIZED, "Unauthorized: Invalid Token"),
    TOKEN_MALFORMED("4012", HttpStatus.UNAUTHORIZED, "Unauthorized: Token malformed"),
    TOKEN_EXPIRED("4013", HttpStatus.UNAUTHORIZED, "Unauthorized: Token expired"),
    TOKEN_TYPE("4014", HttpStatus.UNAUTHORIZED, "Unauthorized: Wrong token type"),
    TOKEN_UNSUPPORTED("4015", HttpStatus.UNAUTHORIZED, "Unauthorized: Unsupported token"),
    TOKEN_UNKNOWN("4016", HttpStatus.UNAUTHORIZED, "Unknown Error"),

    // NOT_FOUND: 404
    USER_NOT_FOUND("4040", HttpStatus.NOT_FOUND, "Not Found: User Not Found"),
    ITEM_NOT_FOUND("4041", HttpStatus.NOT_FOUND, "Not Found: Item Not Found"),
    BASKET_IS_EMPTY("4042", HttpStatus.NOT_FOUND, "Not Found: Basket is Empty"),
    ORDER_NOT_FOUND("4043", HttpStatus.NOT_FOUND, "Not Found: Order Not Found"),
    BAKSET_NOT_FOUND("4044", HttpStatus.NOT_FOUND, "Not Found: Basket Not Found"),
    // CONFLICT: 409
    USER_EXIST("4090", HttpStatus.CONFLICT, "Conflict: An account with this userNickname already exists."),
    USERID_EXIST("4091", HttpStatus.CONFLICT, "Conflict: An account with this userId already exists."),
    ITEM_EXIST("4092", HttpStatus.CONFLICT, "Conflict: An item with this item already exists"),
    // GONE: 410
    USER_DELETE("4010", HttpStatus.GONE, "GONE: User delete data"),
    USER_EXPEL("4011", HttpStatus.GONE, "GONE: USER expelled"),


    // INTERNAL_SERER_ERROR: 500
    SERVER_ERROR("5000", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: Internal server error"),
    FILE_CONVERT_ERROR("5001", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: Internal file convert error"),
    FILE_UPLOAD_ERROR("5002", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: Internal file upload error");
    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;
}
