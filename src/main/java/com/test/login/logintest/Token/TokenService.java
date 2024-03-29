package com.test.login.logintest.Token;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class TokenService {

    private HashMap<Token, String> tokenList = new HashMap<>();

    public HashMap<Token, String> getTokenList() {
        return tokenList;
    }

    public void setTokenList(HashMap<Token, String> tokenList) {
        this.tokenList = tokenList;
    }

    public Token createValidToken(String username) {
        String uuid = UUID.randomUUID().toString();
        Token token = new Token(uuid);
        if (!uuid.isBlank()) {
            addTokenToList(token, username);
            return token;
        }
        throw new RuntimeException();
    }

    private void addTokenToList(Token token, String username) {
        this.tokenList.put(token, username);
    }

    boolean authenticateToken(Token token) {
        return !tokenList.get(token).isBlank();
    }
}
