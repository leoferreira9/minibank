package com.leonardo.minibank.controller;

import com.leonardo.minibank.dto.account.DepositRequest;
import com.leonardo.minibank.dto.account.TransferRequest;
import com.leonardo.minibank.dto.account.WithdrawRequest;
import com.leonardo.minibank.dto.transaction.TransactionDTO;
import com.leonardo.minibank.exception.ResourceNotFoundException;
import com.leonardo.minibank.model.Account;
import com.leonardo.minibank.repository.AccountRepository;
import com.leonardo.minibank.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public TransactionDTO deposit(@Validated @RequestBody DepositRequest depositRequest){
        return accountService.deposit(depositRequest.getAccountId(), depositRequest.getAmount());
    }

    @PostMapping("/withdraw")
    public TransactionDTO withdraw(@Validated @RequestBody WithdrawRequest withdrawRequest){
        return accountService.withdraw(withdrawRequest.getAccountId(), withdrawRequest.getAmount());
    }

    @PostMapping("/transfer")
    public TransactionDTO transfer(@Validated @RequestBody TransferRequest transferRequest){

        return accountService.transfer(
                transferRequest.getFromAccountId(),
                transferRequest.getToAccountId(),
                transferRequest.getAmount()
        );
    }
}
