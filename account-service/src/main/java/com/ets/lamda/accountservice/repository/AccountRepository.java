package com.ets.lamda.accountservice.repository;

import com.ets.lamda.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}