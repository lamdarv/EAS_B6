package com.ets.lamda.geraiservice.controller;

import com.ets.lamda.geraiservice.dto.GeraiResponse;
import com.ets.lamda.geraiservice.service.GeraiService;
import com.ets.lamda.geraiservice.dto.GeraiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerai")
@RequiredArgsConstructor
public class GeraiController {

    private final GeraiService geraiService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGerai(@RequestBody GeraiRequest geraiRequest) {
        geraiService.createGerai(geraiRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GeraiResponse> getAllGerai() {
        return geraiService.getAllGerai();
    }

}