package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.client.repository.AddressRepository;
import com.tawseel.clients_server.table.client.repository.ClientRepository;
import com.tawseel.clients_server.table.item.repository.ItemRepository;
import com.tawseel.clients_server.table.order.repository.OrderRepository;
import com.tawseel.clients_server.table.client.Addresses;
import com.tawseel.clients_server.table.client.Client;
import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.order.Order;
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

    public Client findClientById(Integer clientId) {
        Client client = clientRepository.findClientById(clientId);
        if (client != null) {
            Integer defaultAddressId = client.getDefaultAddressId();
            if (defaultAddressId != null) {
                client.setDefaultAddress(addressRepository.findAddressesById(defaultAddressId));
            }
        }

        return client;
    }

    @Transactional
    public boolean updateClientDetails(Client client) {
        boolean isUpdated = false;
        if (client != null) {
            Set<Addresses> addresses = client.getAddresses();
            if (addresses != null) {
                addresses.forEach(addresses1 -> addresses1.setClientID(client.getId()));
            }

            Addresses defaultAddress = client.getDefaultAddress();
            if (defaultAddress != null) {
                client.setDefaultAddressId(defaultAddress.getId());
            }

            clientRepository.saveAndFlush(client);
            isUpdated = true;
        }

        return isUpdated;
    }

    public List<Item> getRecommendedItems(Integer clientID) {
        List<Item> keyList = null;
        List<Item> recommendedItems = new ArrayList<>();
        Client client = clientRepository.findClientById(clientID);
        List<Order> orders = orderRepository.findAllByClient(client);

        if (!orders.isEmpty()) {
            keyList = sortedHighestScoredItems(orders);
            if(keyList.size() > 0) {
                Item item = keyList.get(0);
                recommendedItems = itemRepository
                        .findAllByCategory(item.getCategory())
                        .stream()
                        .limit(3)
                        .collect(Collectors.toList());
            }
        }

        if(keyList == null || keyList.isEmpty()){  //in case the user is new and no orders, we need to return a global recs.
            orders = orderRepository.findAll();
            keyList = sortedHighestScoredItems(orders);
            if (keyList.size() >= 3) {
                for (int i = 0; i < 3; i++) {
                    Item item = keyList.get(i);
                    recommendedItems.add(item);
                }
            }
        }

        return recommendedItems;
    }

    public static List<Item> sortedHighestScoredItems(List<Order> orders) {
        Map<Item, Integer> itemToScore = new HashMap<>();
        for (Order order : orders) {
            Item item = order.getItem();
            if(item != null) {
                Integer score = itemToScore.get(item);
                itemToScore.put(item, (score == null) ? 1 : score + 1);
            }
        }

        List<Item> keyList = new ArrayList<>(sortMap(itemToScore).keySet());
        Collections.reverse(keyList);
        return keyList;
    }

    private static Map<Item, Integer> sortMap(Map<Item, Integer> map) {
        return map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}

