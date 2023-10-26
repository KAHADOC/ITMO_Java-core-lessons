package com.company.project.lesson12.exception;

public class UserException extends Exception{
    private User user;

    public UserException(String message, User user) {
        super(message);
        this.user = user;
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }
}

