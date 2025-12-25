// package com.example.demo.security;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.stereotype.Component;

// import java.io.IOException;
// import java.io.Serializable;

// @Component
// public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

//     private static final long serialVersionUID = -7858869558953243875L;

//     @Override
//     public void commence(HttpServletRequest request, HttpServletResponse response,
//                          AuthenticationException authException) throws IOException, ServletException {
        
//         // This is called when a user tries to access a secured REST resource without supplying any credentials
//         // We send a 401 Unauthorized response
//         response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//     }
// }

package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}