package com.dentaloffice.service.impl;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.model.Appoitment;
import com.dentaloffice.model.DTO.AppoitmentDTO;
import com.dentaloffice.repository.AppoitmentRepository;
import com.dentaloffice.repository.PatientRepository;
import com.dentaloffice.service.DentistService;
import com.dentaloffice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private AppoitmentRepository appoitmentRepository;
    private PatientRepository patientRepository;
    private EmailService emailService;

    @Autowired
    public DentistServiceImpl(AppoitmentRepository appoitmentRepository, PatientRepository patientRepository) {
        this.appoitmentRepository = appoitmentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<AppoitmentDTO> getAppoitments() {
        return toDTOs(appoitmentRepository.findAllNotCanceled());
    }

    private List<AppoitmentDTO> toDTOs(List<Appoitment> appoitments) {
        List<AppoitmentDTO> appoitmentDTOs = new ArrayList<>();

        Iterator<Appoitment> it = appoitments.iterator();
        while (it.hasNext()) {
            AppoitmentDTO appoitmentDTO = new AppoitmentDTO(it.next());
            appoitmentDTOs.add(appoitmentDTO);
        }

        return appoitmentDTOs;
    }

    public Boolean cancelAppointment(Long appointmentId) throws NotFoundException, MessagingException {
        Appoitment appointment = this.appoitmentRepository.findById(appointmentId).orElseThrow(() -> new NotFoundException());
        appointment.setCanceled(true);
        this.appoitmentRepository.save(appointment);

        if (appointment.getPatient().getUser().getEmail() != null)
            this.emailService.sendAppointmentCanceledNotification(appointment);

        return true;
    }

}
