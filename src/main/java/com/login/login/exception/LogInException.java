package com.login.login.exception;

public class LogInException extends RuntimeException {
    public LogInException(String message) {
        super(message);
    }
    public LogInException(String message, Throwable cause) {
        super(message, cause);

    }
    public LogInException(Throwable cause) {
        super(cause);
    }
}
