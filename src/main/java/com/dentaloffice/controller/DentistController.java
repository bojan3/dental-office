package com.dentaloffice.controller;

import com.dentaloffice.model.Appoitment;
import com.dentaloffice.model.DTO.AppoitmentDTO;
import com.dentaloffice.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/dentist", produces = MediaType.APPLICATION_JSON_VALUE)
public class DentistController {

    private DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<AppoitmentDTO>> getAppoitments(){
        List<AppoitmentDTO> appoitments = this.dentistService.getAppoitments();
        return new ResponseEntity<List<AppoitmentDTO>>(appoitments, HttpStatus.OK);
    }

    @DeleteMapping(value = "appointment/cancel/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        Boolean response = false;
        try {
            response = this.dentistService.cancelAppointment(id);
        }catch (Exception e) {
            return new ResponseEntity<Boolean>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

}
