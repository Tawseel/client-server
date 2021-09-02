package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByClientID (Integer clientID);
}
