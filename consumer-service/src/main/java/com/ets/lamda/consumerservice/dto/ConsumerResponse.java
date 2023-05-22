package com.ets.lamda.consumerservice.dto;

import lombok.Data;

@Data
public class ConsumerResponse {

    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
//    private List<OrderResponse> orders;

}
