package com.ets.lamda.consumerservice.dto;

import lombok.Data;

@Data
public class ConsumerRequest {

    private String name;
    private String email;
    private String address;
    private String phoneNumber;

}
