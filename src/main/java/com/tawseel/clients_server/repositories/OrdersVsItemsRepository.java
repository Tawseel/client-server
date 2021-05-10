package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.OrdersVsItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersVsItemsRepository extends JpaRepository<OrdersVsItems, Integer> {
}
