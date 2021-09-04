package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Addresses;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ItemRepository itemRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
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

    public List<Item> getRecommendedItems(Integer clientID)
    {
        //todo: Logic needed
        return itemRepository.findAll();
    }
}
