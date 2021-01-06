# Optimus Prime Service
> RESTful service which calculates and returns all the prime numbers up to and including a number provided.

### Code Highlights
* 100% code coeverage with JUnit5 Tests
* Full integration tests available
* Cached Responses utilising Spring boot cache, to improve performance
* Supports both JSON and XML response using jackson-dataformat-xml package
* User can utilise any one of the algorithm to calculate prime number using
 an optional request parameter

### Tech stack / Requirements
* Spring Boot
* JDK 8
* Build Tool Used: Maven
* Testing: Junit5, Springboot tester

## Application run, test commands
* mvn spring-boot:run
* mvn clean test

###### JSON Response

Request `curl -X GET -H "Accept: application/json" http://localhost:8080/primes/7?algorithm=Eratosthenes`\

Response `{"Initial":7,"Primes":[2,3,5,7]}`


###### XML Response

Request `curl -X GET -H "Accept: application/xml" http://localhost:8080/primes/7?algorithm=Eratosthenes`\

Response `<PrimesResponse><Initial>7</Initial><Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Primes></PrimesResponse>`


## Algorithm's Used
* Seive Eratosthenes Method
* Basic n/2 factorail method
