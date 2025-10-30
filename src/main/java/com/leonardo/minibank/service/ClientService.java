package com.leonardo.minibank.service;

import com.leonardo.minibank.dto.client.ClientCreateDTO;
import com.leonardo.minibank.dto.client.ClientDTO;
import com.leonardo.minibank.model.Client;
import com.leonardo.minibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO create(ClientCreateDTO clientCreateDTO){
        Client client = new Client(null, clientCreateDTO.getName(), clientCreateDTO.getEmail());
        clientRepository.save(client);
        return new ClientDTO(client.getId(), client.getName(), client.getEmail());
    }

    public List<ClientDTO> findAll(){
        List<Client> clientList = clientRepository.findAll();
        List<ClientDTO> clientDtoList = new ArrayList<>();

        for(Client c: clientList){
            clientDtoList.add(new ClientDTO(
               c.getId(),
               c.getName(),
               c.getEmail()
            ));
        }

        return clientDtoList;
    }
}
