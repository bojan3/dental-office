package com.dentaloffice.service.impl;

import com.dentaloffice.controller.model.Appoitment;
import com.dentaloffice.controller.model.DTO.AppoitmentDTO;
import com.dentaloffice.repository.AppoitmentRepository;
import com.dentaloffice.service.EmailService;
import com.dentaloffice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private AppoitmentRepository appoitmentRepository;

    private EmailService emailService;

    @Autowired
    public PatientServiceImpl(AppoitmentRepository appointmentRepository, EmailService emailService) {
        this.appoitmentRepository = appointmentRepository;
        this.emailService = emailService;
    }

    @Override
    public List<AppoitmentDTO> getAppoitments(String phoneNumber){
        return toDTOs(appoitmentRepository.findAllNotCanceled(), phoneNumber);
    }

    @Override
    public Boolean cancelAppointment(Long id) throws MessagingException {
        Appoitment appointment = appoitmentRepository.findById(id).orElse(null);

        if (appointment.canPatientCancel()) {
            appointment.setCanceled(true);
            this.appoitmentRepository.save(appointment);
            if (appointment.getPatient().getUser().getEmail() != null)
                this.emailService.sendAppointmentCanceledNotification(appointment);
            return true;
        }
       return false;
    }

    private List<AppoitmentDTO> toDTOs(List<Appoitment> appoitments,String phoneNumber) {
        List<AppoitmentDTO> appoitmentDTOs = new ArrayList<>();

        Iterator<Appoitment> it = appoitments.iterator();
        while (it.hasNext()) {
            AppoitmentDTO appoitmentDTO = new AppoitmentDTO(it.next(), phoneNumber);
            appoitmentDTOs.add(appoitmentDTO);
        }

        return appoitmentDTOs;
    }

}
