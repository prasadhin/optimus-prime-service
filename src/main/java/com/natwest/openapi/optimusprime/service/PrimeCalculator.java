package com.natwest.openapi.optimusprime.service;

import com.natwest.openapi.optimusprime.model.PrimeResponse;

public interface PrimeCalculator {
    PrimeResponse getPrimes(String algorithm, int count);
}
