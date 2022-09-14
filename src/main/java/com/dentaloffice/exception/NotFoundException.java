package com.dentaloffice.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Appointment not found");
    }

}
