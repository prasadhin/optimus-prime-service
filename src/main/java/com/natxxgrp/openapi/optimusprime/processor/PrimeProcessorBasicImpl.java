package com.natxxgrp.openapi.optimusprime.processor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Basic Algorithm to check if a number is Prime
 * ---------------------------------------------
 * A prime number (P) is a number greater than 1 whose only factors are 1 and the number (P) itself. Generally, we can determine a number is prime or not in below steps:
 *
 * 2 is only prime number which is also even number. So, if given number N is 2 the it is PRIME number.
 * If given number N is even number then it is NOT PRIME number.
 * Find out square root on N. Traverse all odd numbers up to the sqrt(N) and try to devide the N with current odd number. If remainder is 0 for any odd number then number is NOT PRIME.
 * Else – number is PRIME.
 */

public class PrimeProcessorBasicImpl implements PrimeProcessor {

    @Override
    public List<Integer> getPrimes(int count){
        return IntStream.rangeClosed(2, count)
                .filter(this::checkifPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean checkifPrime(Integer number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

}
