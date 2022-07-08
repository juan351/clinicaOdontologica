package com.example.clinicaOdontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.apache.log4j.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHanlder(Exception ex, WebRequest request){
        logger.error("Error: " + ex.getMessage());
        return new ResponseEntity<>("Error de servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
