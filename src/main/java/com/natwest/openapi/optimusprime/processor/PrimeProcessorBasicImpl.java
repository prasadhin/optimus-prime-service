package com.natwest.openapi.optimusprime.processor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
