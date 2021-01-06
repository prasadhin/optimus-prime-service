package com.natwest.openapi.optimusprime.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeProcessorEratosthenesImpl implements PrimeProcessor {
    // Form list of prime numbers from 2 to the nth number given
    // Algorithm - Sieve of Eratosthenes
    @Override
    public  List<Integer> getPrimes(int count) {
        // mark all elements as "true" in the array, indexed from 0 to n.
        boolean[] primes = new boolean[count + 1];
        Arrays.fill(primes, true);

        //iterator from 2 to y until y*y will be greater than n
        for (int i = 2; i * i <= count; i++) {
            // cont if number is not being marked already
            if (primes[i]) {
                // find multiples and make them as false
                for (int j = i * i; j <= count; j += i)
                    primes[j] = false;
            }
        }

        // populate the prime numbers list from the array
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= count; i++) {
            if (primes[i])
                primeNumbers.add(i);
        }
        return primeNumbers;
    }
}
