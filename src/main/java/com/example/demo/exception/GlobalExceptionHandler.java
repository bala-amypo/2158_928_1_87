// package com.example.demo.exception;

// import org.springframework.http.*;

// import org.springframework.web.bind.annotation.*;

// @RestControllerAdvice

// public class GlobalExceptionHandler {

//     @ExceptionHandler(ValidationException.class)

//     public ResponseEntity<String> handleValidation(ValidationException ex) {

//         return ResponseEntity.badRequest().body(ex.getMessage());

//     }

//     @ExceptionHandler(ResourceNotFoundException.class)

//     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {

//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

//     }

//}

package com.example.demo.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
            errors.put(err.getField(), err.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(
            ResourceNotFoundException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
