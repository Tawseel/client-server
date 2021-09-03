package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.CartOrderValueRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.*;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.order.CardOrderValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            order.setCardOrderValueList(new HashSet<>(temporaryOrder.getValues()));
            for (CardOrderValue value : temporaryOrder.getValues()) {
                value.setOrderID(order.getId());
            }
            orderRepository.flush();
        }

        return true;
    }

    private Order createOrderFromTemporaryOrderList(Integer clientID, TemporaryOrder temporaryOrder) {
        Item item = temporaryOrder.getItem();

        Client client = clientRepository.findClientById(clientID);

        return new Order(0,
                LocalDateTime.now(),
                item,
                item.getPrice(),
                client,
                OrderStatus.New,
                item.getStoreID(),
                new HashSet<>());
    }

    public List<Order> getPurchaseHistory(Client client)
    {
        List<Order> purchaseHistory = orderRepository.findAllByClient(client);
        return purchaseHistory;
    }


}
