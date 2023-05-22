package com.ets.lamda.accountservice.service;

import com.ets.lamda.accountservice.repository.AccountRepository;
import com.ets.lamda.accountservice.dto.AccountRequest;
import com.ets.lamda.accountservice.dto.AccountResponse;
import com.ets.lamda.accountservice.model.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public void createAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .email(accountRequest.getEmail())
                .password(accountRequest.getPassword())
                .build();

        accountRepository.save(account);
        log.info("Account {} is saved", account.getId());
    }

    public List<AccountResponse> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(this::mapToAccountResponse).toList();
    }

    private AccountResponse mapToAccountResponse(Account account) {
        return AccountResponse.builder()
                .id(account.getId())
                .email(account.getEmail())
                .password(account.getEmail())
                .build();
    }

}
