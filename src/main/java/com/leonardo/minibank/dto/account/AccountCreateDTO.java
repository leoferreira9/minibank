package com.leonardo.minibank.dto.account;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AccountCreateDTO {

    @NotNull
    @Positive
    private Integer accountNumber;

    @NotNull
    private Long clientId;

    public AccountCreateDTO(){}

    public AccountCreateDTO(Integer accountNumber, Long clientId){
        this.accountNumber = accountNumber;
        this.clientId = clientId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}