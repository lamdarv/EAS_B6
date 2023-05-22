package com.ets.lamda.accountservice.controller;

import com.ets.lamda.accountservice.dto.AccountResponse;
import com.ets.lamda.accountservice.service.AccountService;
import com.ets.lamda.accountservice.dto.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts();
    }

}