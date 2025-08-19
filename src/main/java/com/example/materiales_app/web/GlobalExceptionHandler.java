package com.example.materiales_app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<Map<String,Object>> onConstraintViolation(jakarta.validation.ConstraintViolationException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("message","Validación de datos");
        body.put("errors", ex.getConstraintViolations().stream()
                .map(cv -> Map.of("property", cv.getPropertyPath().toString(), "error", cv.getMessage()))
                .toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
