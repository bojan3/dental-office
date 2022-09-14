package com.dentaloffice.service.impl;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.model.Appoitment;
import com.dentaloffice.model.DTO.CreateAppointmentDTO;
import com.dentaloffice.model.Patient;
import com.dentaloffice.repository.AppoitmentRepository;
import com.dentaloffice.repository.PatientRepository;
import com.dentaloffice.service.AppointmentService;
import com.dentaloffice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

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

    public Boolean createAppointment(CreateAppointmentDTO appointmentData) throws MessagingException {
        Patient patient = this.patientRepository.findByPhoneNumber(appointmentData.getPatientPhoneNumber());

        if (patient == null) {
            patient = new Patient(appointmentData.getPatientPhoneNumber());
            patientRepository.save(patient);
        }

        Appoitment appointment = new Appoitment(appointmentData, patient);
        Boolean response = appoitmentRepository.save(appointment) != null;

        if (response)
            emailService.sendAppoitmentCreatedNotification(appointment);

        return response;
    }

    public Boolean cancelAppointment(Long appointmentId) throws NotFoundException, MessagingException {
        Appoitment appointment = this.appoitmentRepository.findById(appointmentId).orElseThrow(() -> new NotFoundException());
        this.appoitmentRepository.delete(appointment);

        if (appointment.getPatient().getUser().getEmail() != null)
            this.emailService.sendAppointmentCanceledNotification(appointment);

        return true;
    }

}


