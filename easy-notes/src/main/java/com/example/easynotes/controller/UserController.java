package com.example.easynotes.controller;

import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by amer on 2/18/18.
 */

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers(){ return userRepository.findAll(); }

    // Create a New User


    // Get a Single User

    // Update a User

    // Delete a User
}
