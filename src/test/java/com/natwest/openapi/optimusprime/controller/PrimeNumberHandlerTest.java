package com.natwest.openapi.optimusprime.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PrimeNumberHandlerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void getPrimesJson() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("/primes/30?type=Basic", HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("{\"Initial\":30,\"Primes\":[2,3,5,7,11,13,17,19,23,29]}", responseEntity.getBody());
    }

    @Test
    public void getPrimesXml() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange("/primes/10?type=Basic", HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("<PrimeResponse>" +
                        "<Initial>10</Initial>" +
                        "<Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Primes>" +
                        "</PrimeResponse>",
                responseEntity.getBody());
    }
}