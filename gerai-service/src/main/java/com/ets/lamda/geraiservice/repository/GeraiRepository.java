package com.ets.lamda.geraiservice.repository;

import com.ets.lamda.geraiservice.model.Gerai;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeraiRepository extends MongoRepository<Gerai, String> {
}