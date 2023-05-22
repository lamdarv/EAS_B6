package com.ets.lamda.accountingservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accounting {
    @Id
    private String orderId;
    private String customerId;
    private String paymentType;
    private Double amount;
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public void setUsername(String username) {
    }
}
