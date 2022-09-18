package com.dentaloffice.service;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.controller.model.DTO.AppoitmentDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface DentistService {

    List<AppoitmentDTO> getAppoitments();

    public Boolean cancelAppointment(Long appointmentId) throws NotFoundException, MessagingException;
}
