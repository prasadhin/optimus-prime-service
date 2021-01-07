package com.natxxgrp.openapi.optimusprime.service;

import com.natxxgrp.openapi.optimusprime.exception.DataIntegrityViolationException;
import com.natxxgrp.openapi.optimusprime.model.PrimeResponse;
import com.natxxgrp.openapi.optimusprime.processor.PrimeProcessorBasicImpl;
import com.natxxgrp.openapi.optimusprime.processor.PrimeProcessorEratosthenesImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Buider factory pattern.
 * The class gets the appropriate Prime number generator based on the algorithm requested
 * --------------------------------------------------------------------------------------
 */
@Component
public class PrimeCalculatorImpl implements PrimeCalculator{

    @Override
    @Cacheable("primes")
    public PrimeResponse getPrimes(String algorithm, int count){
        isNumberValid(count);
        switch (algorithm) {
            case "Basic":
                return new PrimeResponse(count, new PrimeProcessorBasicImpl().getPrimes(count));
            case "Eratosthenes":
                return new PrimeResponse(count,new PrimeProcessorEratosthenesImpl().getPrimes(count));
            default:
                return new PrimeResponse(count,new PrimeProcessorBasicImpl().getPrimes(count));
        }
    }

    /**
     * Basic check to invalidate a negative number.
     * Throw an exception when negative number is found.
     */
    private void isNumberValid(int number){
        if(number < 0 ) {
            throw new DataIntegrityViolationException("Invalid input number, cannot be less than 2");
        }
    }
}
