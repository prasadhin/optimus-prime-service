package com.natwest.openapi.optimusprime.service;

import com.natwest.openapi.optimusprime.model.PrimeResponse;
import com.natwest.openapi.optimusprime.processor.PrimeProcessorBasicImpl;
import com.natwest.openapi.optimusprime.processor.PrimeProcessorEratosthenesImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PrimeCalculatorImpl implements PrimeCalculator{

    @Override
    @Cacheable("primes")
    public PrimeResponse getPrimes(String algorithm, int count){
        switch (algorithm) {
            case "Basic":
                return new PrimeResponse(count, new PrimeProcessorBasicImpl().getPrimes(count));
            case "Eratosthenes":
                return new PrimeResponse(count,new PrimeProcessorEratosthenesImpl().getPrimes(count));
            default:
                return new PrimeResponse(count,new PrimeProcessorBasicImpl().getPrimes(count));
        }
    }
}
