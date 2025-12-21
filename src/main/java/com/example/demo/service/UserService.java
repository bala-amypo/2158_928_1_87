package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public User save(User user) {
        return repo.save(user);
    }
}
