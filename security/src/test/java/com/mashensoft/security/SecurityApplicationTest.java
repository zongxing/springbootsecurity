package com.mashensoft.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void user() {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}