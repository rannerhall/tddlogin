package com.test.login.logintest.Token;

import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenServiceTest {
    private TokenService tokenService = new TokenService();
    private Token token;
    private User user;

    @BeforeEach
    void setUpTokenServiceTest() {
        user = new User("Anna", "losen");
        token = tokenService.createValidToken(user.getUsername());
    }

    @Test
    void checks_that_the_token_is_present_in_the_list() {
        assertTrue(tokenService.authenticateToken(token));
    }
}