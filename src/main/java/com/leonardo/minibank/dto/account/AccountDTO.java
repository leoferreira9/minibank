package com.leonardo.minibank.dto.account;

import com.leonardo.minibank.dto.client.ClientDTO;

public class AccountDTO {

    private Long id;

    private Integer accountNumber;

    private Double balance = 0.0;

    private ClientDTO clientDTO;

    public AccountDTO(){}

    public AccountDTO(Long id, Integer accountNumber, Double balance, ClientDTO clientDTO){
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.clientDTO = clientDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }
}
