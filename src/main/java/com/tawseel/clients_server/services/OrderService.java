package com.tawseel.clients_server.services;

import com.tawseel.clients_server.table.Order;
import com.tawseel.clients_server.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Integer clientID, Order orderToAdd)
    {
        if(orderToAdd != null)
        {
            orderToAdd.setClientID(clientID);
            orderRepository.saveAndFlush(orderToAdd);
        }
    }

    public List<Order> getPurchaseHistory(Integer clientID)
    {
        List<Order> purchaseHistory = orderRepository.findAllByClientID(clientID);
        return purchaseHistory;
    }
}
