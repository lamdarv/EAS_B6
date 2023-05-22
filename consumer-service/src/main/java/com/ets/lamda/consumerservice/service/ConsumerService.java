package com.ets.lamda.consumerservice.service;

import com.ets.lamda.consumerservice.exception.ResourceNotFoundException;
import com.ets.lamda.consumerservice.model.Consumer;
import com.ets.lamda.consumerservice.repository.ConsumerRepository;
import com.ets.lamda.consumerservice.security.AccessTokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private AccessTokenService accessTokenService;

    public Consumer verifyConsumer(String token) {
        Claims claims = accessTokenService.verifyToken(token);

        Long consumerId = claims.get("consumerId", Long.class);

        return consumerRepository.findById(consumerId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumer", "id", consumerId));
    }
}
