package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.order.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClientServiceTest {

    @Test
    void sortedHighestScoredItems() {
        List<Order> orders = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item newItem = new Item();
            newItem.setId(i);
            items.add(newItem);
            Order newOrder = new Order();
            newOrder.setItem(newItem);
            orders.add(newOrder);
        }

        Order order = new Order();
        order.setItem(items.get(0));
        for (int i = 0; i < 10; i++) {
            orders.add(order);
        }

        List<Item> items1 = ClientService.sortedHighestScoredItems(orders);

        for (Item item : items1) {
            System.out.println(item);
        }
    }

}