package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection ONLY
    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ---------------- REGISTER ----------------
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        if (request.email == null || request.password == null) {
            throw new ValidationException("Email and password must not be null");
        }

        User user = new User();
        user.setFullName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);

        return userService.registerUser(user);
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        User user = userService.getByEmail(request.email);

        // IMPORTANT: password check
        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new ValidationException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        return new JwtResponse(token);
    }
}
