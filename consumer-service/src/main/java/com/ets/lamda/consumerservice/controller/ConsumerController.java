package com.ets.lamda.consumerservice.controller;

import com.ets.lamda.consumerservice.dto.ConsumerRequest;
import com.ets.lamda.consumerservice.dto.ConsumerResponse;
import com.ets.lamda.consumerservice.exception.ResourceNotFoundException;
import com.ets.lamda.consumerservice.exception.UnauthorizedException;
import com.ets.lamda.consumerservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping("api/order")
    public ResponseEntity<String> placeOrder(@RequestBody ConsumerRequest consumerRequest) throws UnauthorizedException {
        return consumerService.placeOrder(consumerRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumerResponse> getConsumer(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return consumerService.getConsumer(id);
    }

}

