package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Addresses;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ItemRepository itemRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
    }

    public Client findClientById (Integer clientId)
    {
        Client client = clientRepository.findClientById(clientId);
        return client;
    }

    @Transactional
    public Boolean updateClientDetails(Integer clientId, Client client)
    {
        if(clientId != null) {
            Set<Addresses> addresses = client.getAddresses();
            if(addresses != null) {
                addresses.forEach(addresses1 -> addresses1.setClientID(clientId));
            }
            clientRepository.saveAndFlush(client);
        }
        return true;
    }

    public List<Item> getRecommendedItems(Integer clientID)
    {
        //todo: Logic needed
        return itemRepository.findAll();
    }
}
