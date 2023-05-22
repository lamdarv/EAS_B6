package com.ets.lamda.accountingservice.controller;

import com.ets.lamda.accountingservice.dto.AccountingRequest;
import com.ets.lamda.accountingservice.dto.AccountingResponse;
import com.ets.lamda.accountingservice.model.Accounting;
import com.ets.lamda.accountingservice.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {

    @Autowired
    private AccountingService accountingService;

    @PostMapping("/process")
    public AccountingResponse processPayment(@Valid @RequestBody AccountingRequest accountingRequest) {
        Accounting accounting = new Accounting();
        accounting.setAmount(accountingRequest.getAmount());
        accounting.setCardNumber(accountingRequest.getCardNumber());
        accounting.setCardNumber(accountingRequest.getCardType());

        return accountingService.processPayment(accounting);
    }

}
