package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById (Integer itemID);
}
