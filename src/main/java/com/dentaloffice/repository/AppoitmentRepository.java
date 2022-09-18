package com.dentaloffice.repository;

import com.dentaloffice.controller.model.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppoitmentRepository extends JpaRepository<Appoitment, Long> {

    @Query(value = "select * from appoitment where canceled = false", nativeQuery = true)
    List<Appoitment> findAllNotCanceled();
    @Query(value = "select count(id) from appoitment where (start_date_time in (?1) and duration = 1) or (start_date_time in (?2) and duration = 0)", nativeQuery = true)
    Integer countConflicts(List<LocalDateTime> longConfilctDT, List<LocalDateTime> shortConflictDT);
}
