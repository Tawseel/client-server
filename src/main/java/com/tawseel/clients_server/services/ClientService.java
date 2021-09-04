package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.AddressRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Addresses;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository,
                         ItemRepository itemRepository,
                         AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
    }

    public Client findClientById (Integer clientId)
    {
        Client client = clientRepository.findClientById(clientId);
        Integer defaultAddressId = client.getDefaultAddressId();
        if( defaultAddressId != null) {
            client.setDefaultAddress(addressRepository.findAddressesById(defaultAddressId));
        }
        return client;
    }

    @Transactional
    public boolean updateClientDetails(Integer clientId, Client client)
    {
        if(clientId != null) {
            Set<Addresses> addresses = client.getAddresses();
            if(addresses != null) {
                addresses.forEach(addresses1 -> addresses1.setClientID(clientId));
            }
            Addresses defaultAddress = client.getDefaultAddress();
            if(defaultAddress != null) {
                client.setDefaultAddressId(defaultAddress.getId());
            }
            System.out.println(defaultAddress);
            System.out.println();
            System.out.println(client.getDefaultAddress());
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
