package com.dentaloffice.controller.model.DTO;

import com.dentaloffice.controller.model.AppointmentType;
import com.dentaloffice.controller.model.Appoitment;
import com.dentaloffice.controller.model.AppoitmentDuration;

import java.time.LocalDateTime;

public class AppoitmentDTO {

    private Long id;

    private PatientDTO patient;

    private LocalDateTime startDateTime;

    private AppoitmentDuration duration;

    private AppointmentType type;

    private Boolean mine;

    public AppoitmentDTO(Appoitment appointment, String phoneNumber) {
        this.id = appointment.getId();
        this.patient = new PatientDTO(appointment.getPatient());
        this.startDateTime = appointment.getStartDateTime();
        this.duration = appointment.getDuration();
        this.type = appointment.getType();
        this.mine = (appointment.getPatient().getUser().getPhoneNumber().equals(phoneNumber));
    }

    public AppoitmentDTO(Appoitment appointment) {
        this.id = appointment.getId();
        this.patient = new PatientDTO(appointment.getPatient());
        this.startDateTime = appointment.getStartDateTime();
        this.duration = appointment.getDuration();
        this.type = appointment.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public AppoitmentDuration getDuration() {
        return duration;
    }

    public void setDuration(AppoitmentDuration duration) {
        this.duration = duration;
    }

    public AppointmentType getType() {
        return type;
    }

    public void setType(AppointmentType type) {
        this.type = type;
    }

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }
}
