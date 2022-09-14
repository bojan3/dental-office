package com.dentaloffice.repository;

import com.dentaloffice.model.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appoitment, Long> {

}
