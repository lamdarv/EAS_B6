package com.ets.lamda.deliveryservice.dto;

import lombok.Data;

@Data
public class DeliveryRequest {
    private Long orderId;
    private String destination;
}