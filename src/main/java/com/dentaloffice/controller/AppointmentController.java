package com.dentaloffice.controller;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.model.DTO.AppoitmentDTO;
import com.dentaloffice.model.DTO.CreateAppointmentDTO;
import com.dentaloffice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

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
    public ResponseEntity<Boolean> createAppointment(@RequestBody CreateAppointmentDTO appointment){
        Boolean response = false;
        try {
        response = this.appointmentService.createAppointment(appointment);
        } catch (Exception e){
            return new ResponseEntity<Boolean>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        Boolean response = false;
        try {
             response = this.appointmentService.cancelAppointment(id);
        }catch (Exception e) {
            return new ResponseEntity<Boolean>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }
}
