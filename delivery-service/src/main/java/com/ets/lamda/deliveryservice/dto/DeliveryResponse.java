package com.ets.lamda.deliveryservice.dto;

import lombok.Data;

@Data
public class DeliveryResponse {
    private Long id;
    private Long orderId;
    private String status;
    private String currentLocation;
    private String destination;
}
