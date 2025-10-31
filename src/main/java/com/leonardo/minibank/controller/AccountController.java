package com.leonardo.minibank.controller;

import com.leonardo.minibank.dto.account.AccountCreateDTO;
import com.leonardo.minibank.dto.account.AccountDTO;
import com.leonardo.minibank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public AccountDTO create(@Validated @RequestBody AccountCreateDTO accountCreateDTO){
        return accountService.create(accountCreateDTO);
    }

    @GetMapping
    public List<AccountDTO> findAll(){
        return accountService.findAll();
    }
}
