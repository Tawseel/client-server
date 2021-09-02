package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.OrdersVsItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersVsItemsRepository extends JpaRepository<OrdersVsItems, Integer> {
}
