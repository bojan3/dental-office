package com.dentaloffice.service.impl;

import com.dentaloffice.exception.DateTimeConfilctException;
import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.controller.model.Appoitment;
import com.dentaloffice.controller.model.AppoitmentDuration;
import com.dentaloffice.controller.model.DTO.AppoitmentDTO;
import com.dentaloffice.controller.model.DTO.CreateAppointmentDTO;
import com.dentaloffice.controller.model.Patient;
import com.dentaloffice.repository.AppoitmentRepository;
import com.dentaloffice.repository.PatientRepository;
import com.dentaloffice.service.AppointmentService;
import com.dentaloffice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppoitmentRepository appoitmentRepository;
    private PatientRepository patientRepository;
    private EmailService emailService;

    @Autowired
    public AppointmentServiceImpl(AppoitmentRepository appoitmentRepository, PatientRepository patientRepository,
                                  EmailService emailService) {
        this.appoitmentRepository = appoitmentRepository;
        this.patientRepository = patientRepository;
        this.emailService = emailService;
    }

    public Boolean createAppointment(CreateAppointmentDTO appointmentData) throws MessagingException, DateTimeConfilctException {

        if (appointmentData.getDuration() == AppoitmentDuration.LONG){
            if (checkForLongConflict(appointmentData))
                throw new DateTimeConfilctException();
        } else {
            if (checkForShortConflict(appointmentData))
                throw new DateTimeConfilctException();
        }

        Patient patient = this.patientRepository.findByPhoneNumber(appointmentData.getPatientPhoneNumber());

        if (patient == null) {
            patient = new Patient(appointmentData.getPatientPhoneNumber());
            patientRepository.save(patient);
        }

        Appoitment appointment = new Appoitment(appointmentData, patient);
        appoitmentRepository.save(appointment);

        if(appointment.getPatient().getUser().getEmail() != null)
            emailService.sendAppoitmentCreatedNotification(appointment);

        return true;
    }

    private boolean checkForLongConflict(CreateAppointmentDTO appointmentData){
        ArrayList<LocalDateTime> longConflictDT = new ArrayList<LocalDateTime>();
        longConflictDT.add(appointmentData.getStartDateTime().minusMinutes(30));
        longConflictDT.add(appointmentData.getStartDateTime());
        longConflictDT.add(appointmentData.getStartDateTime().plusMinutes(30));

        ArrayList<LocalDateTime> shortConflictDT = new ArrayList<LocalDateTime>();
        shortConflictDT.add(appointmentData.getStartDateTime());
        shortConflictDT.add(appointmentData.getStartDateTime().plusMinutes(30));

        return appoitmentRepository.countConflicts(longConflictDT, shortConflictDT) > 0;
    }

    private boolean checkForShortConflict(CreateAppointmentDTO appointmentData){
        ArrayList<LocalDateTime> longConflictDT = new ArrayList<LocalDateTime>();
        longConflictDT.add(appointmentData.getStartDateTime().minusMinutes(30));
        longConflictDT.add(appointmentData.getStartDateTime());

        ArrayList<LocalDateTime> shortConflictDT = new ArrayList<LocalDateTime>();
        shortConflictDT.add(appointmentData.getStartDateTime());

        return appoitmentRepository.countConflicts(longConflictDT, shortConflictDT) > 0;
    }

    @Override
    public AppoitmentDTO getAppointment(Long id) {
        Appoitment appointment = this.appoitmentRepository.findById(id).orElse(null);
        if (appointment == null)
            throw new NotFoundException();
        return new AppoitmentDTO(appointment);
    }

}


