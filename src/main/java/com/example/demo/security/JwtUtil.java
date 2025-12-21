package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "secretkey123";
    private final long EXPIRATION = 86400000;

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
