package com.dentaloffice.repository;

import com.dentaloffice.controller.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "select * from patient natural join user where user.phone_number = ?1", nativeQuery = true)
    Patient findByPhoneNumber(String patientPhoneNumber);

}
