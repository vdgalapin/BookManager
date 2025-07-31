package com.example.bookmanage.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class) 
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}