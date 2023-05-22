package com.ets.lamda.kitchenservice.service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AccessTokenService {

    public String generateAccessToken(String email) {
        String accessToken = UUID.randomUUID().toString();
        // code to save accessToken to database with email as key
        // ...
        return accessToken;
    }

    public boolean validateAccessToken(String accessToken) {
        // code to check if accessToken is valid
        // ...
        return true;
    }

    public void deleteAccessToken(String accessToken) {
        // code to delete accessToken from database
        // ...
    }
}
