package com.example.identity_service.exception;

public enum  ErrorCode {
    UNCATEGORIZED_EXCEPTION(999,"Uncategorized error"),
    USER_EXISTED(1001,"User existed"),
    USER_NOT_EXISTED(1005,"User not existed"),
    UNAUTHENTICATED(1006,"Unauthenticated")
    ;
    ErrorCode(int code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
