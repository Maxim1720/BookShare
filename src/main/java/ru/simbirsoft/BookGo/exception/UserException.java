package ru.simbirsoft.BookGo.exception;

public class UserException extends Exception {
    private final ExceptionEnum exceptionEnum;
    private final String message;
    public UserException(ExceptionEnum exceptionEnum, String message) {
        this.exceptionEnum = exceptionEnum;
        this.message = message;
    }
    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
