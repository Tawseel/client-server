package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.order.CardOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardOrderRepository extends JpaRepository<CardOrder, Integer> {
    List<CardOrder> findCardOrderByUserId(int userId);
}
