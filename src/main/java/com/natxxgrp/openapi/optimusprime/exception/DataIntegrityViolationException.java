package com.natxxgrp.openapi.optimusprime.exception;

/**
 * Exception for capturing an invalid data.
 */
public class DataIntegrityViolationException  extends RuntimeException {
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
