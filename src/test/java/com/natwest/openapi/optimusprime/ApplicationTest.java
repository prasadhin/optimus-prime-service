package com.natwest.openapi.optimusprime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTest {

    //This test ensures 100% code coverage
    @Test
    public void ccontextShouldNotLoadWhenPropertiesIncorrect() {
        Application.main(new String[] {});
        Exception exception = assertThrows(ApplicationContextException.class, () -> {
            SpringApplication.run(ApplicationTest.class, "--spring.profiles.active=incorrect");
        });
        String expectedMessage = "Unable to start web server";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}