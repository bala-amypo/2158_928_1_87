// package com.example.demo.service;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.exception.ValidationException;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class UserService {
//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     public User registerUser(User user) {
//         if (userRepository.existsByEmail(user.getEmail())) throw new ValidationException("Email already in use");
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return userRepository.save(user);
//     }

//     public User getUser(Long id) {
//         return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }

//     public List<User> getAllUsers() { return userRepository.findAll(); }
//     public User getByEmail(String email) { return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found")); }
// }

package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    User getByEmail(String email);
}