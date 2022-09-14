package com.dentaloffice.service;

import com.dentaloffice.model.Appoitment;
import com.dentaloffice.model.DTO.AppoitmentDTO;

import java.util.List;

public interface DentistService {

    List<AppoitmentDTO> getAppoitments();
}
