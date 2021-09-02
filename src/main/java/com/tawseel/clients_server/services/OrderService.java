package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Item;
import com.tawseel.clients_server.table.Order;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    ItemRepository itemRepository;

    public boolean addOrder(Integer userId, List<TemporaryOrder> temporaryOrders)
    {
        LocalDateTime dateTime = LocalDateTime.now();

//        for(temporaryOrders i : temporaryOrders) {
//            //todo: add validations.
//            Item item = itemRepository.findItemById(itemId);
//            if(item != null)
//            {
//                int storeId = item.getStoreID();
//            } else { return false; }
//
//        }
//
//        if(orderToAdd != null)
//        {
//            orderToAdd.setUserId(userId);
//            orderRepository.saveAndFlush(orderToAdd);
//        }
        return true;
    }

    public List<Order> getPurchaseHistory(Integer clientID)
    {
        List<Order> purchaseHistory = orderRepository.findAllByClientID(clientID);
        return purchaseHistory;
    }


}
