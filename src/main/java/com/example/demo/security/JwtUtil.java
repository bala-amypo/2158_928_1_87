// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;
// import com.example.demo.entity.User;
// import javax.annotation.PostConstruct;
// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtUtil {

//     private String secret = "your_very_secure_and_long_secret_key_32_characters_long";
//     private long expiration = 86400000; // 24 hours
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

//     // FIX: Add this method for the Test Suite
//     public Claims parseToken(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String extractEmail(String token) {
//         return parseToken(token).getSubject();
//     }

//     public boolean isTokenValid(String token, String email) {
//         final String tokenEmail = extractEmail(token);
//         return (tokenEmail.equals(email) && !isTokenExpired(token));
//     }

//     private boolean isTokenExpired(String token) {
//         return parseToken(token).getExpiration().before(new Date());
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import com.example.demo.entity.User;
import jakarta.annotation.PostConstruct; // Correct Jakarta import
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private String secret = "this_is_a_very_secure_long_secret_key_32_chars";
    private long expiration = 86400000; 
    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Required by CarbonFootprintEstimatorTest
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return parseToken(token).getSubject();
    }

    public boolean isTokenValid(String token, String email) {
        final String tokenEmail = extractEmail(token);
        return (tokenEmail.equals(email) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}