package com.ets.lamda.geraiservice.service;

import com.ets.lamda.geraiservice.repository.GeraiRepository;
import com.ets.lamda.geraiservice.dto.GeraiRequest;
import com.ets.lamda.geraiservice.dto.GeraiResponse;
import com.ets.lamda.geraiservice.model.Gerai;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GeraiService {

    private final GeraiRepository geraiRepository;

    public void createGerai(GeraiRequest geraiRequest) {
        Gerai gerai = Gerai.builder()
                .name(geraiRequest.getName())
                .address(geraiRequest.getAddress())
                .build();

        geraiRepository.save(gerai);
        log.info("Gerai {} is saved", gerai.getId());
    }

    public List<GeraiResponse> getAllGerai() {
        List<Gerai> gerai = geraiRepository.findAll();

        return gerai.stream().map(this::mapToGeraiResponse).toList();
    }

    private GeraiResponse mapToGeraiResponse(Gerai gerai) {
        return GeraiResponse.builder()
                .id(gerai.getId())
                .name(gerai.getName())
                .address(gerai.getAddress())
                .build();
    }
}