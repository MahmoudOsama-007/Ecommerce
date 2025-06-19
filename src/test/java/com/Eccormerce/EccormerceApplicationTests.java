package com.Eccormerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EccormerceApplicationTests {

    @Test
    void contextLoads() {
        // Test to ensure that the Spring context loads correctly
    }

    @Test
    public void main() {
        // Test the main method to ensure it runs without exceptions
        String[] args = {};
        EccormerceApplication.main(args);
    }
}
