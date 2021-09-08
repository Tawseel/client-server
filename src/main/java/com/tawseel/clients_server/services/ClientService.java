package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.AddressRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> keyList;
        Map<Integer, Integer> map = new HashMap<>();
        List<Item> recommendedItems = new ArrayList<>();
        Client client = clientRepository.findClientById(clientID);
        List<Order> orders = orderRepository.findAllByClient(client);

        if(!orders.isEmpty()) {
            keyList = sortedHighestScoredItems(map, orders);
            Item item = itemRepository.findItemById(keyList.get(0));
            //todo: need to limit
            recommendedItems = itemRepository.findAllByCategory(item.getCategory());
        }
        else //in case the user is new and no orders, we need to return a global recs.
        {
            orders = orderRepository.findAll();
            keyList = sortedHighestScoredItems(map, orders);
            if(keyList.size() >= 3)
            {
                for(int i = 0; i < 3; i++)
                {
                    Item item = itemRepository.findItemById(keyList.get(i));
                    recommendedItems.add(item);
                }
            }
        }

        return recommendedItems;
    }

    private List<Integer> sortedHighestScoredItems(Map<Integer, Integer> map, List<Order> orders) {
        for(Order i: orders)
        {
            Integer j = map.get(i.getItem().getId());
            map.put(i.getItem().getId(), (j == null) ? 1 : j + 1);
        }
        Map<Integer, Integer> sortedMap = sortMap(map);
        List<Integer> keyList = addMapValuesToList(sortedMap);
        Collections.reverse(keyList);
        return keyList;
    }


    public Map<Integer, Integer> sortMap(Map<Integer, Integer> map)
    {
        Map<Integer, Integer> temp = new HashMap<>();

        temp = map.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return temp;
    }

    public List<Integer> addMapValuesToList(Map<Integer, Integer> map)
    {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            list.add(entry.getKey());
        }
        return list;
    }
}

