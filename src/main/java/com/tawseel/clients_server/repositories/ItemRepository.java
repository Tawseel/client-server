package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById (Integer itemId);
}
