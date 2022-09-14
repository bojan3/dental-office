package com.dentaloffice.service.impl;

import com.dentaloffice.model.Appoitment;
import com.dentaloffice.model.DTO.AppoitmentDTO;
import com.dentaloffice.model.Patient;
import com.dentaloffice.model.Role;
import com.dentaloffice.model.User;
import com.dentaloffice.repository.AppoitmentRepository;
import com.dentaloffice.repository.PatientRepository;
import com.dentaloffice.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private AppoitmentRepository appoitmentRepository;
    private PatientRepository patientRepository;

    @Autowired
    public DentistServiceImpl(AppoitmentRepository appoitmentRepository, PatientRepository patientRepository) {
        this.appoitmentRepository = appoitmentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<AppoitmentDTO> getAppoitments() {
        return toDTOs(appoitmentRepository.findAll());
    }

    private List<AppoitmentDTO> toDTOs(List<Appoitment> appoitments) {
        List<AppoitmentDTO> appoitmentDTOs = new ArrayList<>();

        Iterator<Appoitment> it = appoitments.iterator();
        while (it.hasNext()) {
            AppoitmentDTO appoitmentDTO = new AppoitmentDTO(it.next());
            appoitmentDTOs.add(appoitmentDTO);
        }

        return appoitmentDTOs;
    }
}
