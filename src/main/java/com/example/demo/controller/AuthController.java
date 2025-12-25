// package com.example.demo.controller;

// import com.example.demo.dto.JwtResponse; // Ensure this import is correct
// import com.example.demo.dto.LoginRequest;
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
//     public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) { // Use JwtResponse here
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//         );

//         User user = userService.getByEmail(request.getEmail());
//         String token = jwtUtil.generateTokenForUser(user);
        
//         // Match the constructor of your JwtResponse class
//         return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getEmail(), user.getRole()));
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.JwtResponse; // Corrected DTO name
import com.example.demo.dto.LoginRequest; //
import com.example.demo.dto.RegisterRequest; //
import com.example.demo.entity.User; //
import com.example.demo.security.JwtUtil; //
import com.example.demo.service.UserService; //
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager; //
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") //
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // Constructor injection as required
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register") //
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        // Map DTO to Entity manually to avoid Lombok issues
        User user = new User();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        
        User registeredUser = userService.registerUser(user); //
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login") //
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        // 1. Authenticate user credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Fetch user data to generate token claims
        User user = userService.getByEmail(request.getEmail());
        String token = jwtUtil.generateTokenForUser(user);
        
        // 3. Return the JwtResponse with manual constructor
        return ResponseEntity.ok(new JwtResponse(
                token, 
                user.getId(), 
                user.getEmail(), 
                user.getRole()
        ));
    }
}