package com.leonardo.minibank.dto.account;

public class WithdrawRequest {

    private Double amount;

    public WithdrawRequest(){}

    public WithdrawRequest(Double amount){
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
