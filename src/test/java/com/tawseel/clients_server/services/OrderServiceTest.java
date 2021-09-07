package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
import com.tawseel.clients_server.table.order.CardOrderValue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        int clientId = 7;
        Item item = itemRepository.findItemById(12);
        List<TemporaryOrder> temporaryOrderList = new ArrayList<>();
        List<CardOrderValue> cardOrderValueList = new ArrayList<>();
        cardOrderValueList.add(new CardOrderValue( "test", "test", 69));
        cardOrderValueList.add(new CardOrderValue( "tes2t", "test2", 69));
        temporaryOrderList.add(new TemporaryOrder(item, cardOrderValueList));
        orderService.addOrder(clientId, temporaryOrderList);
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
        int clientID = 6;
        List<Item> items = clientService.getRecommendedItems(6);
        for (Item item: items)
        {
            System.out.println(item);
        }
    }
}