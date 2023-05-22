package com.ets.lamda.deliveryservice.service;

import com.ets.lamda.deliveryservice.exception.ResourceNotFoundException;
import com.ets.lamda.deliveryservice.dto.DeliveryRequest;
import com.ets.lamda.deliveryservice.dto.DeliveryResponse;
import com.ets.lamda.deliveryservice.exception.UnauthorizedException;
import com.ets.lamda.deliveryservice.model.Delivery;
import com.ets.lamda.deliveryservice.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final AccessTokenService accessTokenService;
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(AccessTokenService accessTokenService, DeliveryRepository deliveryRepository) {
        this.accessTokenService = accessTokenService;
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryResponse scheduleDelivery(DeliveryRequest deliveryRequest, String accessToken) {
        if (!accessTokenService.validateAccessToken(accessToken)) {
            throw new UnauthorizedException("Invalid access token");
        }
        Delivery delivery = new Delivery(deliveryRequest);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return new DeliveryResponse(savedDelivery);
    }

    public void updateDeliveryLocation(Long deliveryId, String location, String accessToken) {
        if (!accessTokenService.validateAccessToken(accessToken)) {
            throw new UnauthorizedException("Invalid access token");
        }
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id " + deliveryId));
        delivery.setLocation(location);
        deliveryRepository.save(delivery);
    }

    public void recordPickup(Long deliveryId, String accessToken) {
        if (!accessTokenService.validateAccessToken(accessToken)) {
            throw new UnauthorizedException("Invalid access token");
        }
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id " + deliveryId));
        delivery.setPickedUp(true);
        deliveryRepository.save(delivery);
    }

    public void recordDelivery(Long deliveryId, String accessToken) {
        if (!accessTokenService.validateAccessToken(accessToken)) {
            throw new UnauthorizedException("Invalid access token");
        }
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id " + deliveryId));
        delivery.setDelivered(true);
        deliveryRepository.save(delivery);
    }

}
