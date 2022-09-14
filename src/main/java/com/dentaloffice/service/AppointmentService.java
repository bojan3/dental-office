package com.dentaloffice.service;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.model.DTO.CreateAppointmentDTO;

import javax.mail.MessagingException;

public interface AppointmentService {
    Boolean createAppointment(CreateAppointmentDTO appointment) throws MessagingException;

    public Boolean cancelAppointment(Long appointmentId) throws NotFoundException, MessagingException;
}
