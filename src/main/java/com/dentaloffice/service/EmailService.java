package com.dentaloffice.service;

import com.dentaloffice.controller.model.Appoitment;

import javax.mail.MessagingException;

public interface EmailService {

    public void sendAppointmentCanceledNotification(Appoitment appointment) throws MessagingException;

    public void sendAppoitmentCreatedNotification(Appoitment appointment) throws MessagingException;

}
