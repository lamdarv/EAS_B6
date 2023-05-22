package com.ets.lamda.accountingservice.service;

import com.ets.lamda.accountingservice.dto.AccountingRequest;
import com.ets.lamda.accountingservice.dto.AccountingResponse;
import com.ets.lamda.accountingservice.model.Accounting;
import com.ets.lamda.accountingservice.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AccountingService {

    private AccountingRepository accountingRepository;
    private AccessTokenService accessTokenService;

    @Autowired
    public AccountingService(AccountingRepository accountingRepository, AccessTokenService accessTokenService) {
        this.accountingRepository = accountingRepository;
        this.accessTokenService = accessTokenService;
    }

    public Accounting createAccounting(String token, AccountingRequest accountingRequest) {
        String username = accessTokenService.getUsernameFromAccessToken(token);
        // perform verification of credit/debit card details here
        // ...
        Accounting accounting = new Accounting();
        accounting.setUsername(username);
        accounting.setAmount(accountingRequest.getAmount());
        accounting.setPaymentType(accountingRequest.getType());
        return accountingRepository.save(accounting);
    }

    public List<Accounting> getAccountingByUsername(String token) {
        String username = accessTokenService.getUsernameFromAccessToken(token);
        return accountingRepository.findByUsername(username);
    }

    public AccountingResponse processPayment(Accounting accounting) {
        return null;
    }
}
