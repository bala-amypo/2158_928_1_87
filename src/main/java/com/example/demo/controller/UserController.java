package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;

import com.example.demo.entity.User;

import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    @PostMapping

    public User createUser(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setFullName(request.name);

        user.setEmail(request.email);

        user.setPassword(request.password);

        return userService.registerUser(user);

    }

}

