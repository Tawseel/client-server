package com.tawseel.clients_server.services;

import com.tawseel.clients_server.db_classes.Components;
import com.tawseel.clients_server.db_classes.Item;
import com.tawseel.clients_server.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Components> getComponentsByItemID(Integer itemID)
    {
        //better exception.
        Item item = itemRepository.findItemById(itemID);
        if(item != null) {
            Set<Components> components = item.getComponents();
            List<Components> list = new ArrayList<>(components);
            return list;
        }
        else
        {
            return new ArrayList<>();
        }
    }
}
