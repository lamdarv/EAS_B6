package com.ets.lamda.kitchenservice.service;

import com.ets.lamda.kitchenservice.dto.KitchenRequest;
import com.ets.lamda.kitchenservice.dto.KitchenResponse;
import com.ets.lamda.kitchenservice.repository.KitchenRepository;
import com.ets.lamda.kitchenservice.exception.ResourceNotFoundException;
import com.ets.lamda.kitchenservice.model.Kitchen;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KitchenService {

    private final KitchenRepository kitchenRepository;
    private final AccessTokenService accessTokenService;

    public KitchenResponse createKitchen(KitchenRequest kitchenRequest, String accessToken) {
        if (!accessTokenService.validateAccessToken(accessToken)) {
            throw new UnauthorizedException("Invalid access token");
        }

        Kitchen kitchen = new Kitchen();
        kitchen.setName(kitchenRequest.getName());
        kitchen.setLocation(kitchenRequest.getLocation());
        kitchen.setStatus(Kitchen.KitchenStatus.AVAILABLE);
        kitchen.setTicketNumber(UUID.randomUUID().toString());

        kitchenRepository.save(kitchen);

        KitchenResponse kitchenResponse = new KitchenResponse();
        kitchenResponse.setId(kitchen.getId());
        kitchenResponse.setName(kitchen.getName());
        kitchenResponse.setLocation(kitchen.getLocation());
        kitchenResponse.setStatus(kitchen.getStatus());
        kitchenResponse.setTicketNumber(kitchen.getTicketNumber());

        return kitchenResponse;
    }

    public KitchenResponse getKitchenById(Long id) {
        Kitchen kitchen = kitchenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kitchen not found"));
        KitchenResponse kitchenResponse = new KitchenResponse();
        kitchenResponse.setId(kitchen.getId());
        kitchenResponse.setName(kitchen.getName());
        kitchenResponse.setLocation(kitchen.getLocation());
        kitchenResponse.setStatus(kitchen.getStatus());
        kitchenResponse.setTicketNumber(kitchen.getTicketNumber());
        return kitchenResponse;
    }

    public void updateKitchenStatus(Long id, Kitchen.KitchenStatus status) {
        Kitchen kitchen = kitchenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kitchen not found"));
        kitchen.setStatus(status);
        kitchenRepository.save(kitchen);
    }
}
