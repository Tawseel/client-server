package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.CardOrderRepository;
import com.tawseel.clients_server.table.order.CardOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    CardOrderRepository cardOrderRepository;

    public boolean addOrderToCard(Integer userId, CardOrder cardOrder) {
        if(userId != null && cardOrder != null) {
            cardOrder.setUserId(userId);
            cardOrderRepository.saveAndFlush(cardOrder);
            return true;
        }

        return false;
    }

    public List<CardOrder> getClientCard(Integer userId) {
        return cardOrderRepository.findCardOrderByUserId(userId);
    }
}
