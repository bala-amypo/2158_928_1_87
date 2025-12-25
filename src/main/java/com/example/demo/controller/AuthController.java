// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.JwtResponse;
// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import com.example.demo.security.JwtUtil;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     // Strict Constructor Injection
//     public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         // Handles duplicate email validation inside userService
//         return userService.registerUser(user);
//     }

//     @PostMapping("/login")
//     public JwtResponse login(@RequestBody LoginRequest loginRequest) {
//         // Find user by email
//         User user = userService.getByEmail(loginRequest.getEmail());
        
//         // Check password match
//         if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//             // Generates token containing userId, email, and role
//             String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
//             return new JwtResponse(token);
//         } else {
//             throw new RuntimeException("Invalid credentials");
//         }
//     }
// }

// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.LoginResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final AuthenticationManager authenticationManager;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.authenticationManager = authenticationManager;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
//         User user = new User();
//         user.setFullName(request.getName());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         return ResponseEntity.ok(userService.registerUser(user));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//         );

//         User user = userService.getByEmail(request.getEmail());
//         String token = jwtUtil.generateTokenForUser(user);
        
//         return ResponseEntity.ok(new LoginResponse(token, user.getId(), user.getEmail(), user.getRole()));
//     }
//}

package com.example.demo.controller;

import com.example.demo.dto.JwtResponse; // Corrected import
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // Constructor Injection
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        // 1. Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Fetch user details to generate token
        User user = userService.getByEmail(request.getEmail());
        String token = jwtUtil.generateTokenForUser(user);
        
        // 3. Return JwtResponse as required
        return ResponseEntity.ok(new JwtResponse(
                token, 
                user.getId(), 
                user.getEmail(), 
                user.getRole()
        ));
    }
}