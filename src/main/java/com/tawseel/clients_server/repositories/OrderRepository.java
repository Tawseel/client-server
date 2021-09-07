package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByClient(Client client);
    Order findOrderById(Integer orderID);
}
