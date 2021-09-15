package com.tawseel.clients_server.table.order.repository;

import com.tawseel.clients_server.table.order.CardOrderValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartOrderValueRepository extends JpaRepository<CardOrderValue, Integer> {

}
