package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Used in login
    public User getByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    // Used in register
    public User save(User user) {
        return repo.save(user);
    }

    //  FIX 1: Used by UserController
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    //  FIX 2: Used by UserController
    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ValidationException("User not found"));
    }
}
