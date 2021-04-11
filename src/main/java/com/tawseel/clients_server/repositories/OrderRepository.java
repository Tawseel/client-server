package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
