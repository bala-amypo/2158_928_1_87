package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ValidationException;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Used by login
    public User getByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    // Used by register
    public User save(User user) {
        return repo.save(user);
    }

    //  Used by UserController
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    //  Used by UserController
    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ValidationException("User not found"));
    }
}
