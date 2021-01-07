package com.natxxgrp.openapi.optimusprime.service;

import com.natxxgrp.openapi.optimusprime.model.PrimeResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCalculatorImplTest {

    private PrimeCalculator primeCalculator;

    @BeforeEach
    public void setUp() {
        primeCalculator = new PrimeCalculatorImpl();
    }

    @AfterEach
    public void tearDown() {
        primeCalculator = null;
    }

    @Test
    public void getPrimesForBasicMethodTest() {
        PrimeResponse primeResponse = primeCalculator.getPrimes("Basic",7);
        assertEquals(new Integer(7), primeResponse.getInitial());
        assertEquals(getExpectedPrimeResult(),primeResponse.getPrimes());
    }

    @Test
    public void getPrimesForEratosthenesTest() {
        PrimeResponse primeResponse = primeCalculator.getPrimes("Eratosthenes",7);
        assertEquals(new Integer(7), primeResponse.getInitial());
        assertEquals(getExpectedPrimeResult(),primeResponse.getPrimes());
    }

    @Test
    public void getPrimesForDefaultTest() {
        PrimeResponse primeResponse = primeCalculator.getPrimes("",7);
        assertEquals(new Integer(7), primeResponse.getInitial());
        assertEquals(getExpectedPrimeResult(),primeResponse.getPrimes());
    }

    private List<Integer> getExpectedPrimeResult(){
        return Arrays.asList(2,3,5,7);
    }
}