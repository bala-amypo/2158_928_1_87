package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder encoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest req) {
        User user = new User();
        user.setFullName(req.name);
        user.setEmail(req.email);
        user.setPassword(req.password);
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest req) {
        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(req.email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        return new JwtResponse(token);
    }
}
