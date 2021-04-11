package com.tawseel.clients_server.services;

import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients()
    {
        List<Client> list = clientRepository.findAll();
        return list;
    }

    public void addClientToDB(Client client)
    {
        clientRepository.saveAndFlush(client);
    }
}
