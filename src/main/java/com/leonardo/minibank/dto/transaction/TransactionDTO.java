package com.leonardo.minibank.dto.transaction;

import com.leonardo.minibank.model.TransactionType;

import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;
    private TransactionType type;
    private Double value;
    private LocalDateTime date;
    private Long accountId;

    public TransactionDTO(){}

    public TransactionDTO(Long id, TransactionType type, Double value, LocalDateTime date, Long accountId) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
