package com.university.forum.usermanagement.AdminManagement.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleEmailAlreadyExistsException(ElementNotFoundException ex) {
        return new ResponseEntity<>(Map.of("message",ex.getMessage()), HttpStatus.NOT_FOUND); // 404
    }

}
