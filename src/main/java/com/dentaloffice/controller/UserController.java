package com.dentaloffice.controller;

import com.dentaloffice.controller.model.User;
import com.dentaloffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{phoneNumber}")
    public ResponseEntity<User> getUser(@PathVariable String phoneNumber){
        User user = userService.getUser(phoneNumber);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
