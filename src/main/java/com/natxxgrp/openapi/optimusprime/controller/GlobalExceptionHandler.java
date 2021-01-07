package com.natxxgrp.openapi.optimusprime.controller;

import com.natxxgrp.openapi.optimusprime.exception.DataIntegrityViolationException;
import com.natxxgrp.openapi.optimusprime.model.ApiErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Global exception handler for any errors thrown during
 * Controller processing a incoming request
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * exception handler for invalid(negqative) number for
     * calculating the prime number range
     */

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorMessage> exceptionUserNotFound(DataIntegrityViolationException e) {
        return new ResponseEntity<>(
                new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage()),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }
}
