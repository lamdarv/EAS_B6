package com.ets.lamda.accountingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountingRequest {
    private String orderId;
    private String customerId;
    private String paymentType;
    private Double amount;
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public String getCardType() {
    }
}
