package com.start.domain_driven_design.user.exception;

public class PhoneNumberInvalidException extends RuntimeException{

    public PhoneNumberInvalidException(String message) {
        super(message);
    }

    public PhoneNumberInvalidException(String message, Throwable t) {
        super(message,t);
    }
}
