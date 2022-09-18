package com.dentaloffice.service;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.model.DTO.AppoitmentDTO;
import com.dentaloffice.model.DTO.CreateAppointmentDTO;

import javax.mail.MessagingException;

public interface AppointmentService {
    public Boolean createAppointment(CreateAppointmentDTO appointment) throws MessagingException;

    public AppoitmentDTO getAppointment(Long id);

//    Boolean cancelAppointment(Long id) throws MessagingException;
}
