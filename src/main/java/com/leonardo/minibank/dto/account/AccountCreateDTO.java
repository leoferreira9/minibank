package com.leonardo.minibank.dto.account;

public class AccountCreateDTO {

    private Integer accountNumber;
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