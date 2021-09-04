package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.table.Addresses;
import com.tawseel.clients_server.table.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById (int clientId)
    {
        return clientRepository.findClientById(clientId);
    }

    public Boolean updateClientDetails(Client client)
    {
        clientRepository.saveAndFlush(client);
        return true;
    }
}
