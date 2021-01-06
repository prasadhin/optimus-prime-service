package com.natwest.openapi.optimusprime.controller;

import com.natwest.openapi.optimusprime.model.PrimeResponse;
import com.natwest.openapi.optimusprime.service.PrimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class PrimeNumberHandler {

    @Autowired
    PrimeCalculator primeCalculator;

    @GetMapping(value="/primes/{count}", produces={"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity<PrimeResponse> getPrimes(@PathVariable("count") Integer count,
                                                   @RequestParam Optional<String> algorithm) {
        String method = algorithm.orElse("Basic");
        PrimeResponse primeResponse = primeCalculator.getPrimes(method, count);
        return new ResponseEntity<>(primeResponse, HttpStatus.OK);
    }
}
