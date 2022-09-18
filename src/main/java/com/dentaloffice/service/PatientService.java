package com.dentaloffice.service;

import com.dentaloffice.controller.model.DTO.AppoitmentDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface PatientService {

    public List<AppoitmentDTO> getAppoitments(String phoneNumber);

    Boolean cancelAppointment(Long id) throws MessagingException;
}
