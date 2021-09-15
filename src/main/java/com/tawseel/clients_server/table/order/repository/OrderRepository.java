package com.tawseel.clients_server.table.order.repository;

import com.tawseel.clients_server.table.client.Client;
import com.tawseel.clients_server.table.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByClient(Client client);
    Order findOrderById(Integer orderID);
}
