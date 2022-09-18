package com.dentaloffice.controller;

import com.dentaloffice.controller.model.DTO.AppoitmentDTO;
import com.dentaloffice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/appointments/{phoneNumber}")
    public ResponseEntity<List<AppoitmentDTO>> getAppoitments(@PathVariable String phoneNumber) {
        List<AppoitmentDTO> appoitments = this.patientService.getAppoitments(phoneNumber);
        return new ResponseEntity<List<AppoitmentDTO>>(appoitments, HttpStatus.OK);
    }

    @DeleteMapping(value = "appointment/cancel/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        Boolean response = false;
        try {
            response = this.patientService.cancelAppointment(id);
        }catch (Exception e) {
            return new ResponseEntity<Boolean>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

}
