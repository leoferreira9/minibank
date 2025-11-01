package com.leonardo.minibank.dto.account;

public class DepositRequest {

    private Long accountId;
    private Double amount;

    public DepositRequest(){}

    public DepositRequest(Long accountId, Double amount){
        this.accountId = accountId;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
