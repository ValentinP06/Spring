package com.poe.crm.business.service;

import com.poe.crm.business.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrmService {
    ArrayList<Client> clients = new ArrayList<>();
    long index = 0;

    public List<Client> getAllClients() {

        return clients;
    }

    public void addClient(Client client){
        index++;
        client.setId(index);
        clients.add(client);
    }

    public Optional<Client> findClient(Long id){
        for(Client client : clients){
            if(client.getId().equals(id)){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }



}