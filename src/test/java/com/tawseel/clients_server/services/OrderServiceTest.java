package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.ItemRepository;
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

    @Test
    void addOrder() {
        int clientId = 6;
        Item item = itemRepository.findItemById(12);
        List<TemporaryOrder> temporaryOrderList = new ArrayList<>();
        List<CardOrderValue> cardOrderValueList = new ArrayList<>();
        cardOrderValueList.add(new CardOrderValue( "test", "test", 0));
        cardOrderValueList.add(new CardOrderValue( "tes2t", "test2", 0));
        temporaryOrderList.add(new TemporaryOrder(item, cardOrderValueList));
        orderService.addOrder(clientId, temporaryOrderList);
    }
}