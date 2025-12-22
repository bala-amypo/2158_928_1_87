package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // Strict Constructor Injection
    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Handles duplicate email validation inside userService
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        // Find user by email
        User user = userService.getByEmail(loginRequest.getEmail());
        
        // Check password match
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Generates token containing userId, email, and role
            String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
            return new JwtResponse(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}