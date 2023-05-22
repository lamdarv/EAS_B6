package com.ets.lamda.kitchenservice.controller;

import com.ets.lamda.kitchenservice.dto.KitchenRequest;
import com.ets.lamda.kitchenservice.dto.KitchenResponse;
import com.ets.lamda.kitchenservice.exception.ResourceNotFoundException;
import com.ets.lamda.kitchenservice.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kitchens")

public class KitchenController {

    private final KitchenService kitchenService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KitchenResponse createTicket(@RequestBody KitchenRequest kitchenRequest) {
        return kitchenService.createTicket(kitchenRequest);
    }

    @PutMapping("/{ticketId}")
    public void markTicketReady(@PathVariable Long ticketId) throws ResourceNotFoundException {
        kitchenService.markTicketReady(ticketId);
    }
}
