package com.leonardo.minibank.service;

import com.leonardo.minibank.dto.account.AccountCreateDTO;
import com.leonardo.minibank.dto.account.AccountDTO;
import com.leonardo.minibank.dto.client.ClientDTO;
import com.leonardo.minibank.dto.transaction.TransactionDTO;
import com.leonardo.minibank.exception.ResourceNotFoundException;
import com.leonardo.minibank.model.Account;
import com.leonardo.minibank.repository.AccountRepository;
import com.leonardo.minibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TransactionService transactionService;

    public AccountDTO create(AccountCreateDTO dto){

        Account ac = new Account(
                null, dto.getAccountNumber(),
                0.0,
                clientRepository.findById(dto.getClientId()).orElseThrow(() -> new ResourceNotFoundException("Client not found with ID: " + dto.getClientId()))
        );

        Account saved = accountRepository.save(ac);

        ClientDTO clientDTO = new ClientDTO(saved.getClient().getId(), saved.getClient().getName(), saved.getClient().getEmail());

        return new AccountDTO(saved.getId(),
                saved.getAccountNumber(),
                saved.getBalance(),
                clientDTO
        );
    }

    public List<AccountDTO> findAll(){
        List<Account> accountList = accountRepository.findAll();
        List<AccountDTO> accountDtoList = new ArrayList<>();

        for(Account ac: accountList){
            ClientDTO clientDTO = new ClientDTO(ac.getClient().getId(), ac.getClient().getName(), ac.getClient().getEmail());

            accountDtoList.add(new AccountDTO(
                    ac.getId(),
                    ac.getAccountNumber(),
                    ac.getBalance(),
                    clientDTO
            ));
        }

        return accountDtoList;
    }

    public TransactionDTO deposit(Long accountId, Double amount){
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + accountId));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        return transactionService.recordDeposit(account, amount);
    }

    public TransactionDTO withdraw(Long accountId, Double amount){
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + accountId));

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
        return transactionService.recordWithdraw(account, amount);
    }

    public TransactionDTO transfer(Long fromAccountId, Long toAccountId, Double amount){
        Account fromAccount = accountRepository
                .findById(fromAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + fromAccountId));

        Account toAccount = accountRepository
                .findById(toAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + toAccountId));

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        transactionService.recordTransferIn(toAccount, amount);
        return transactionService.recordTransferOut(fromAccount, amount);
    }
}
