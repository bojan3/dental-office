package com.dentaloffice.repository;

import com.dentaloffice.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where phone_number = ?1", nativeQuery = true)
    User getByPhoneNumber(String phoneNumber);

}
