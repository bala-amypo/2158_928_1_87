// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;
// import com.example.demo.entity.User;
// import jakarta.annotation.PostConstruct; 
// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtUtil {
//     private String secret = "this_is_a_very_secure_long_secret_key_32_chars";
//     private long expiration = 86400000; 
//     private Key key;

//     @PostConstruct
//     public void init() {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//     }

//     public String generateTokenForUser(User user) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", user.getId());
//         claims.put("role", user.getRole());
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(user.getEmail())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return extractEmail(token);
//     }

//     public String extractEmail(String token) {
//         return parseToken(token).getSubject();
//     }

//     public Claims parseToken(String token) {
//         return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
//     }

//     public boolean isTokenValid(String token, String email) {
//         return (extractEmail(token).equals(email) && !parseToken(token).getExpiration().before(new Date()));
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import com.example.demo.entity.User;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Ensure this secret is at least 32 characters long
    private String secret = "this_is_a_very_secure_long_secret_key_32_chars";
    private long expiration = 86400000; // 24 hours
    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // Standard method used by AuthController
    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());
        return generateToken(claims, user.getEmail());
    }

    // FIX: Method required by CarbonFootprintEstimatorTest (Map and String args)
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // FIX: Method required for JWT Filter
    public String extractUsername(String token) {
        return extractEmail(token);
    }

    public String extractEmail(String token) {
        return parseToken(token).getSubject();
    }

    // FIX: Method required by test suite to verify roles
    public String extractRole(String token) {
        return (String) parseToken(token).get("role");
    }

    // FIX: Method required by test suite to verify user IDs
    public Long extractUserId(String token) {
        Object userId = parseToken(token).get("userId");
        if (userId instanceof Integer) {
            return ((Integer) userId).longValue();
        }
        return (Long) userId;
    }

    // Required for verification logic
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, String email) {
        final String tokenEmail = extractEmail(token);
        return (tokenEmail.equals(email) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}