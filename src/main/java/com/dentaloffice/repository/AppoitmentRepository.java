package com.dentaloffice.repository;

import com.dentaloffice.model.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appoitment, Long> {

    @Query(value = "select * from appoitment where canceled = false", nativeQuery = true)
    List<Appoitment> findAllNotCanceled();
}
