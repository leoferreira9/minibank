package com.leonardo.minibank.service;

import com.leonardo.minibank.dto.transaction.TransactionDTO;
import com.leonardo.minibank.exception.InsufficientBalanceException;
import com.leonardo.minibank.exception.InvalidTransactionAmountException;
import com.leonardo.minibank.model.Account;
import com.leonardo.minibank.model.Transaction;
import com.leonardo.minibank.model.TransactionType;
import com.leonardo.minibank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO recordDeposit(Account account, Double amount){
        if(amount <= 0) throw new InvalidTransactionAmountException("Amount must be greater than zero");
        Transaction transaction = new Transaction(null, TransactionType.DEPOSIT, amount, account);
        transactionRepository.save(transaction);
        return new TransactionDTO(transaction.getId(),transaction.getType(), transaction.getValue(), LocalDateTime.now(), account.getId());
    }

    public TransactionDTO recordWithdraw(Account account, Double amount){
        if(amount <= 0) throw new InvalidTransactionAmountException("Amount must be greater than zero");
        if(account.getBalance() < amount) throw new InsufficientBalanceException("Insufficient balance: attempted " + amount + ", available " + account.getBalance());
        Transaction transaction = new Transaction(null, TransactionType.WITHDRAW, amount, account);
        transactionRepository.save(transaction);
        return new TransactionDTO(transaction.getId(), transaction.getType(), transaction.getValue(), LocalDateTime.now(), account.getId());
    }

    public TransactionDTO recordTransferOut(Account account, Double amount){
        if(amount <= 0) throw new InvalidTransactionAmountException("Amount must be greater than zero");
        if(account.getBalance() < amount) throw new InsufficientBalanceException("Insufficient balance: attempted " + amount + ", available " + account.getBalance());
        Transaction transaction = new Transaction(null, TransactionType.TRANSFER_OUT, amount, account);
        transactionRepository.save(transaction);
        return new TransactionDTO(transaction.getId(), transaction.getType(), transaction.getValue(), LocalDateTime.now(), account.getId());
    }

    public TransactionDTO recordTransferIn(Account account, Double amount){
        if(amount <= 0) throw new InvalidTransactionAmountException("Amount must be greater than zero");
        Transaction transaction = new Transaction(null, TransactionType.TRANSFER_IN, amount, account);
        transactionRepository.save(transaction);
        return new TransactionDTO(transaction.getId(), transaction.getType(), transaction.getValue(), LocalDateTime.now(), account.getId());
    }
}
