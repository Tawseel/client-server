package com.tawseel.clients_server.table.item.repository;

import com.tawseel.clients_server.table.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById (Integer itemId);
    List<Item> findAllByCategory(String category);
}
