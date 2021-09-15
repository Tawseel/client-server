package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.client.repository.ClientRepository;
import com.tawseel.clients_server.table.item.repository.ItemRepository;
import com.tawseel.clients_server.table.client.Client;
import com.tawseel.clients_server.table.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Test
    void addOrder() {
    }

    @Test
    void getClient()
    {
        int clientID = 6;
        Client client = clientRepository.findClientById(6);
        System.out.println(client);
    }

    @Test
    void getRecommended()
    {
        List<Item> items = clientService.getRecommendedItems(6);
        for (Item item: items)
        {
            System.out.println(item);
        }
    }


}