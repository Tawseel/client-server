package com.tawseel.clients_server.services;

import com.tawseel.clients_server.StatusUpdate;
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
        int totalPrice = 0;
        Order order = null;
        for (TemporaryOrder temporaryOrder : temporaryOrders) {
             order = createOrderFromTemporaryOrderList(clientID, temporaryOrder);
            totalPrice += order.getItem().getPrice();
            order.setValues(new HashSet<>(temporaryOrder.getValues()));
            for (CardOrderValue value : temporaryOrder.getValues()) {
                value.setOrderID(order.getId());
            }
        }
        if(order != null) {
            order.setTotalPrice(totalPrice);
            orderRepository.save(order);
        }
        calculatePointsForClient(clientID, totalPrice);
        orderRepository.flush();
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

    private Order createOrderFromTemporaryOrderList(Integer clientID, TemporaryOrder temporaryOrder) {
        Item item = temporaryOrder.getItem();

        Client client = clientRepository.findClientById(clientID);

        return new Order(0,
                LocalDateTime.now(),
                item,
                0,
                client,
                OrderStatus.New,
                item.getStoreID(),
                new HashSet<>());
    }

    public List<Order> getPurchaseHistory(Integer clientId)
    {
        Client client = clientRepository.findClientById(clientId);
        List<Order> orders = client != null ? orderRepository.findAllByClient(client) : new ArrayList<>();
        return orders;
    }

    public boolean updateOrderStatus(StatusUpdate statusUpdate)
    {
        Order order = orderRepository.findOrderById(statusUpdate.getOrderID());
        if(order != null)
        {
            order.setStatus(statusUpdate.getOrderStatus());
            orderRepository.saveAndFlush(order);
        }
        else { return false; }
        return true;
    }

}
