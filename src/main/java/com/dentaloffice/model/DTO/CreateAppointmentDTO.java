package com.dentaloffice.model.DTO;

import com.dentaloffice.model.AppoitmentDuration;

import java.time.LocalDateTime;

public class CreateAppointmentDTO {

    private String patientPhoneNumber;

    private LocalDateTime startDateTime;

    private AppoitmentDuration duration;

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

    @Override
    public String toString() {
        return "CreateAppointmentDTO{" +
                "patientPhoneNumber='" + patientPhoneNumber + '\'' +
                ", startDateTime=" + startDateTime +
                ", duration=" + duration +
                '}';
    }
}
