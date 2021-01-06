package com.natwest.openapi.optimusprime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrimeResponse {

    @JsonProperty("Initial")
    Integer initial;
    @JsonProperty("Primes")
    List<Integer> primes;

    public PrimeResponse(Integer initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public Integer getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
