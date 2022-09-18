package com.dentaloffice.exception;

public class DateTimeConfilctException extends RuntimeException {

    public DateTimeConfilctException() {
        super("Can't create appointment");
    }

}
