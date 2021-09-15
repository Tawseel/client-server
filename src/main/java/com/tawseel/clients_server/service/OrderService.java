package com.tawseel.clients_server.service;

import com.tawseel.clients_server.util.TemporaryOrder;
import com.tawseel.clients_server.table.order.repository.CartOrderValueRepository;
import com.tawseel.clients_server.table.client.repository.ClientRepository;
import com.tawseel.clients_server.table.order.repository.OrderRepository;
import com.tawseel.clients_server.table.client.Client;
import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.order.CardOrderValue;
import com.tawseel.clients_server.table.order.Order;
import com.tawseel.clients_server.table.order.OrderStatus;
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
        for (TemporaryOrder temporaryOrder : temporaryOrders) {
            Order order = createOrderFromTemporaryOrderList(clientID, temporaryOrder);
            order = orderRepository.save(order);
            order.setValues(new HashSet<>(temporaryOrder.getValues()));
            for (CardOrderValue value : temporaryOrder.getValues()) {
                value.setOrderID(order.getId());
            }
            orderRepository.save(order);
            orderRepository.flush();
        }

        calculatePointsForClient(clientID, temporaryOrders);
        return true;
    }

    private void calculatePointsForClient(Integer clientID, List<TemporaryOrder> temporaryOrders) {
        int totalPrice = temporaryOrders
                .stream()
                .map(TemporaryOrder::getTotalPrice)
                .reduce(Integer::sum)
                .orElse(0);

        Client client = clientRepository.findClientById(clientID);
        client.setPoints((int) (client.getPoints() + (0.1 * totalPrice)));
        clientRepository.saveAndFlush(client);
    }

    private Order createOrderFromTemporaryOrderList(Integer clientID, TemporaryOrder temporaryOrder) {
        Item item = temporaryOrder.getItem();
        //TODO: to builder
        return new Order(0,
                LocalDateTime.now(),
                item,
                temporaryOrder.getTotalPrice(),
                clientRepository.findClientById(clientID),
                OrderStatus.New,
                item.getStoreID(),
                new HashSet<>());
    }

    public List<Order> getPurchaseHistory(Integer clientId) {
        Client client = clientRepository.findClientById(clientId);
        return client != null ? orderRepository.findAllByClient(client) : new ArrayList<>();
    }
}
