package com.leonardo.minibank.dto.account;

public class WithdrawRequest {

    private Long accountId;
    private Double amount;

    public WithdrawRequest(){}

    public WithdrawRequest(Long accountId, Double amount){
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
