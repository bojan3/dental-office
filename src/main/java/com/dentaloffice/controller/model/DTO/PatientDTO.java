package com.dentaloffice.controller.model.DTO;

import com.dentaloffice.controller.model.Patient;

public class PatientDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.firstName = patient.getUser().getFirstName();
        this.lastName = patient.getUser().getLastName();
        this.phoneNumber = patient.getUser().getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
