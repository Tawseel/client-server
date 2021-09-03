package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.CartOrderValueRepository;
import com.tawseel.clients_server.repositories.ClientRepository;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
import com.tawseel.clients_server.table.Order;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.Type;
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

    @Transactional
    public boolean addOrder(Integer clientID, List<TemporaryOrder> temporaryOrders)
    {
        Order orderToAdd = null;
        int orderID;
        if(clientID != null && temporaryOrders != null) {
            int totalPrice = 0;
            for (TemporaryOrder temporaryOrder : temporaryOrders) {
                if (temporaryOrder.getItem() != null) {
                    orderToAdd = new Order();
                    Order orderFromDB = orderRepository.save(orderToAdd);
                    if(orderFromDB != null)
                    {
                        orderID = orderFromDB.getId();
                    } else { return false; }
                    orderToAdd.setItem(temporaryOrder.getItem());
                    orderToAdd.setStoreID(temporaryOrder.getItem().getStoreID());
                    totalPrice += temporaryOrder.getItem().getPrice();
                    Set<CardOrderValue> cardOrderValueSet = new HashSet<>(temporaryOrder.getValues());
                    orderToAdd.setDateTime(LocalDateTime.now());
                    Client client;
                    client = clientRepository.findClientById(clientID);
                    if(client != null) {
                        orderToAdd.setClient(client);
                    } else {return false;}
                    for (CardOrderValue cardOrderValue: cardOrderValueSet)
                    {
                        cardOrderValue.setOrderID(orderID);
                        cartOrderValueRepository.saveAndFlush(cardOrderValue);
                    }
                }
            }
            if(orderToAdd != null)
            {
                orderToAdd.setTotalPrice(totalPrice);
                orderRepository.saveAndFlush(orderToAdd);
            }
        }
        return orderToAdd != null;
    }

    public List<Order> getPurchaseHistory(Client client)
    {
        List<Order> purchaseHistory = orderRepository.findAllByClient(client);
        return purchaseHistory;
    }


}
