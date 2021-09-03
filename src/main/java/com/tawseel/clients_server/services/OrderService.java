package com.tawseel.clients_server.services;

import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.repositories.ItemRepository;
import com.tawseel.clients_server.table.Item;
import com.tawseel.clients_server.table.Order;
import com.tawseel.clients_server.repositories.OrderRepository;
import com.tawseel.clients_server.table.Type;
import com.tawseel.clients_server.table.order.CardOrderValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    ItemRepository itemRepository;

    public boolean addOrder(Integer userId, List<TemporaryOrder> temporaryOrders)
    {
        Order orderToAdd = null;
        if(userId != null && temporaryOrders != null) {
            int totalPrice = 0;
            for (TemporaryOrder temporaryOrder : temporaryOrders) {
                Item item = itemRepository.findItemById(temporaryOrder.getItem().getId());
                if (item != null) {
                    orderToAdd = new Order();
                    orderToAdd.setItemId(temporaryOrder.getItem().getId());
                    int storeId = item.getStoreID();
                    orderToAdd.setStoreId(storeId);
                    totalPrice += item.getPrice();


                    for (CardOrderValue cardOrderValue : temporaryOrder.getValues()) {
                        orderToAdd.addCardOrderValue(cardOrderValue);
                    }
                    orderToAdd.setDateTime(LocalDateTime.now());
                    orderToAdd.setUserId(userId);
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

    public List<Order> getPurchaseHistory(Integer userId)
    {
        List<Order> purchaseHistory = orderRepository.findAllByUserId(userId);
        return purchaseHistory;
    }


}
