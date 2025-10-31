package com.leonardo.minibank.controller;

import com.leonardo.minibank.dto.client.ClientCreateDTO;
import com.leonardo.minibank.dto.client.ClientDTO;
import com.leonardo.minibank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ClientDTO create(@Validated @RequestBody ClientCreateDTO dto){
        return clientService.create(dto);
    }

    @GetMapping
    public List<ClientDTO> findAll(){
        return clientService.findAll();
    }
}
