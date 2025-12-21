

// package com.example.demo.service;

// import com.example.demo.entity.User;

// import com.example.demo.exception.*;

// import com.example.demo.repository.UserRepository;

// import org.springframework.security.crypto.password.PasswordEncoder;

// import java.util.*;
// import org.springframework.stereotype.Service;

// @Service

// public class UserService {

//     private final UserRepository repo;

//     private final PasswordEncoder encoder;

//     public UserService(UserRepository repo, PasswordEncoder encoder) {

//         this.repo = repo;

//         this.encoder = encoder;

//     }

//     public User registerUser(User user) {

//         if (repo.findByEmail(user.getEmail()).isPresent())

//         throw new ValidationException("Email already in use");

//         user.setPassword(encoder.encode(user.getPassword()));

//         return repo.save(user);

//     }

//     public User getUser(Long id) {

//         return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

//     }

//     public List<User> getAllUsers() { return repo.findAll(); }

//     public User getByEmail(String email) {

//         return repo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));

//     }

// }

