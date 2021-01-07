package com.natxxgrp.openapi.optimusprime.processor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeProcessorTest {

    private PrimeProcessor primeProcessor;

    @Test
    void getPrimesUsingBasicImplTest() {
        primeProcessor = new PrimeProcessorBasicImpl();
        List<Integer> primes = primeProcessor.getPrimes(7);
        assertEquals(getExpectedPrimeResult(),primes);
    }

    @Test
    void getPrimesUsingEratosthenesImpl() {
        primeProcessor = new PrimeProcessorEratosthenesImpl();
        List<Integer> primes = primeProcessor.getPrimes(7);
        assertEquals(getExpectedPrimeResult(),primes);
    }

    private List<Integer> getExpectedPrimeResult(){
        return Arrays.asList(2,3,5,7);
    }
}