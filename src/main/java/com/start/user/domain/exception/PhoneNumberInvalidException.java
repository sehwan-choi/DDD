package com.start.user.domain.exception;

public class PhoneNumberInvalidException extends RuntimeException{

    public PhoneNumberInvalidException(String message) {
        super(message);
    }

    public PhoneNumberInvalidException(String message, Throwable t) {
        super(message,t);
    }
}
