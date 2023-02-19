package ru.simbirsoft.BookGo.exception;

public enum UserExceptionEnum implements ExceptionEnum {
    USER_NOT_FOUND(1001, "Cant' find user in DB"),
    USER_EXIST(1002, "User email is almost exist"),
    TOKEN_EXPIRED(1003, "Token is expired."),
    TOKEN_INVALID(1004, "Token is invalid.");

    public int code;
    public String message;

    UserExceptionEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
