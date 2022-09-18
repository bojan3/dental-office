package com.dentaloffice.service.impl;

import com.dentaloffice.exception.NotFoundException;
import com.dentaloffice.controller.model.Role;
import com.dentaloffice.controller.model.User;
import com.dentaloffice.repository.UserRepository;
import com.dentaloffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String phoneNumber) throws NotFoundException {
        User user = this.userRepository.getByPhoneNumber(phoneNumber);

        if(user == null) {
            user = new User(phoneNumber, Role.PATIENT);
            this.userRepository.save(user);
        }

        return user;
    }
}
