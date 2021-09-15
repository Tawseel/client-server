package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.CartOrderValueRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.table.*;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.order.CardOrderValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final CartOrderValueRepository cartOrderValueRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, CartOrderValueRepository cartOrderValueRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.cartOrderValueRepository = cartOrderValueRepository;
    }

    public boolean addOrder(Integer clientID, List<TemporaryOrder> temporaryOrders) {
        int totalPrice = temporaryOrders.stream()
                .map(TemporaryOrder::getItem)
                .map(Item::getPrice)
                .reduce(Integer::sum).orElse(0);
        for (TemporaryOrder temporaryOrder : temporaryOrders) {
            Order order = createOrderFromTemporaryOrderList(clientID, temporaryOrder, totalPrice);
            order = orderRepository.save(order);
            order.setValues(new HashSet<>(temporaryOrder.getValues()));
            for (CardOrderValue value : temporaryOrder.getValues()) {
                value.setOrderID(order.getId());
            }
            orderRepository.save(order);
            orderRepository.flush();
        }
        calculatePointsForClient(clientID, totalPrice);
        return true;
    }

    private void calculatePointsForClient(Integer clientID, Integer orderTotalPrice)
    {
        double newPointsValue;
        Client client = clientRepository.findClientById(clientID);
        newPointsValue = client.getPoints() + (0.1 * orderTotalPrice);
        client.setPoints((int)newPointsValue);
        clientRepository.saveAndFlush(client);
    }

    private Order createOrderFromTemporaryOrderList(Integer clientID, TemporaryOrder temporaryOrder, int totalPrice) {
        Item item = temporaryOrder.getItem();

        Client client = clientRepository.findClientById(clientID);

        return new Order(0,
                LocalDateTime.now(),
                item,
                totalPrice,
                client,
                OrderStatus.New,
                item.getStoreID(),
                new HashSet<>());
    }

    public List<Order> getPurchaseHistory(Integer clientId)
    {
        Client client = clientRepository.findClientById(clientId);
        return client != null ? orderRepository.findAllByClient(client) : new ArrayList<>();
    }
}
