package com.dentaloffice.controller;

import com.dentaloffice.controller.model.DTO.AppoitmentDTO;
import com.dentaloffice.controller.model.DTO.CreateAppointmentDTO;
import com.dentaloffice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Boolean> createAppointment(@RequestBody CreateAppointmentDTO appointment) {
        try {
            Boolean response = this.appointmentService.createAppointment(appointment);
            return new ResponseEntity<Boolean>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<AppoitmentDTO> getAppointment(@PathVariable Long id) {
        AppoitmentDTO appointment = this.appointmentService.getAppointment(id);
        if (appointment == null) {
            return new ResponseEntity<AppoitmentDTO>(appointment, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<AppoitmentDTO>(appointment, HttpStatus.OK);
    }

}
