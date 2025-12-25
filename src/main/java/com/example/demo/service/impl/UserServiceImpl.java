package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Auxiliary constructor for tests or when PasswordEncoder is not provided
    public UserServiceImpl(UserRepository userRepository) {
        this(userRepository, new BCryptPasswordEncoder());
    }

    @Override
public User registerUser(User user) {
    // 1. Test expects existsByEmail check
    if (userRepository.existsByEmail(user.getEmail())) {
        throw new RuntimeException("User already exists");
    }

    // 2. Encode the password (if you have the encoder)
    if (passwordEncoder != null) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    // 3. CRITICAL: You must return the result of the save operation
    // The test's thenAnswer depends on this returned object having the ID set to 1L
    return userRepository.save(user); 
}

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
