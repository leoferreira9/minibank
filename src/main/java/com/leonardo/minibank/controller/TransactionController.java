package com.leonardo.minibank.controller;

import com.leonardo.minibank.dto.account.DepositRequest;
import com.leonardo.minibank.dto.account.TransferRequest;
import com.leonardo.minibank.dto.account.WithdrawRequest;
import com.leonardo.minibank.dto.transaction.TransactionDTO;
import com.leonardo.minibank.exception.ResourceNotFoundException;
import com.leonardo.minibank.model.Account;
import com.leonardo.minibank.repository.AccountRepository;
import com.leonardo.minibank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/deposit")
    public TransactionDTO deposit(@Validated @RequestBody DepositRequest depositRequest){
        Account account = accountRepository
                .findById(depositRequest.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + depositRequest.getAccountId()));

        return transactionService.recordDeposit(account, depositRequest.getAmount());
    }

    @PostMapping("/withdraw")
    public TransactionDTO withdraw(@Validated @RequestBody WithdrawRequest withdrawRequest){
        Account account = accountRepository
                .findById(withdrawRequest.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + withdrawRequest.getAccountId()));

        return transactionService.recordWithdraw(account, withdrawRequest.getAmount());
    }

    @PostMapping("/transfer")
    public TransactionDTO transfer(@Validated @RequestBody TransferRequest transferRequest){

        Account fromAccount = accountRepository
                .findById(transferRequest.getFromAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + transferRequest.getFromAccountId()));

        Account toAccount = accountRepository
                .findById(transferRequest.getToAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + transferRequest.getToAccountId()));


        TransactionDTO transactionDTO = transactionService.recordTransferOut(fromAccount, transferRequest.getAmount());
        transactionService.recordTransferIn(toAccount, transferRequest.getAmount());

        return transactionDTO;
    }
}
