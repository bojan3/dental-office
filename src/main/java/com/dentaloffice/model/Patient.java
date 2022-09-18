package com.dentaloffice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Appoitment> appoitments;

    public Patient() {
    }

    public Patient(String phoneNumber) {
        this.user = new User(phoneNumber, Role.PATIENT);
        this.appoitments = new HashSet<>();
    }

    public Patient(User user) {
        this.user = user;
        this.appoitments = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Appoitment> getAppoitments() {
        return appoitments;
    }

    public void setAppoitments(Set<Appoitment> appoitments) {
        this.appoitments = appoitments;
    }
}