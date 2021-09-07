package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.AddressRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository,
                         ItemRepository itemRepository,
                         AddressRepository addressRepository,
                         OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
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
        Client client = clientRepository.findClientById(clientID);
        List<Order> orders = orderRepository.findAllByClient(client);
        Optional<Pair> maxRecommend = orders.stream()
                .map(order -> new Pair(order.getItem().getId(), 1))
                .reduce((pair, pair2) -> pair.getKey() == pair2.getKey()? new Pair(pair.getKey(), pair.getVal() + pair2.getVal()): pair);
        Item item = itemRepository.findItemById(maxRecommend.get().getKey());
        //todo: need to limit the returned items.
        List<Item> recommendedItemsByCategory = itemRepository.findAllByCategory(item.getCategory());
        return recommendedItemsByCategory;
    }
}

