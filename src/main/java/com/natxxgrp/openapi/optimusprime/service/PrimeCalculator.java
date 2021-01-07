package com.natxxgrp.openapi.optimusprime.service;

import com.natxxgrp.openapi.optimusprime.model.PrimeResponse;

public interface PrimeCalculator {
    PrimeResponse getPrimes(String algorithm, int count);
}
