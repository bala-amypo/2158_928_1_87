package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
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

        Authentication authentication = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                req.email,
                req.password
            )
        );

        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(req.email))
                .findFirst()
                .get();

        String token = jwtUtil.generateToken(user);
        return new JwtResponse(token);
    }
}
