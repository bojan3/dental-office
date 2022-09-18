package com.dentaloffice.controller.model.DTO;

import com.dentaloffice.controller.model.AppointmentType;
import com.dentaloffice.controller.model.AppoitmentDuration;

import java.time.LocalDateTime;

public class CreateAppointmentDTO {

    private String patientPhoneNumber;

    private LocalDateTime startDateTime;

    private AppoitmentDuration duration;

    private AppointmentType type;

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
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

}
