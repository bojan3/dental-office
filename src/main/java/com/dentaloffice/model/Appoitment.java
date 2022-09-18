package com.dentaloffice.model;

import com.dentaloffice.model.DTO.CreateAppointmentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appoitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    private AppoitmentDuration duration;

    private AppointmentType type;

    private Boolean canceled;

    public Appoitment() {
    }

    public Appoitment(Long id) {
        this.id = id;
    }

    public Appoitment(CreateAppointmentDTO appointment, Patient patient) {
        this.patient = patient;
        this.startDateTime = appointment.getStartDateTime();
        this.duration = appointment.getDuration();
        this.type = appointment.getType();
        this.canceled = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}
