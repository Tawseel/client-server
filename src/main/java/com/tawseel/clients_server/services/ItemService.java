package com.tawseel.clients_server.services;

import com.tawseel.clients_server.table.Ingredients;
import com.tawseel.clients_server.table.Item;
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

    public List<Ingredients> getIngredientsByItemID(Integer itemID)
    {
        //better exception.
        Item item = itemRepository.findItemById(itemID);
        if(item != null) {
            Set<Ingredients> ingredients = item.getIngredients();
            List<Ingredients> list = new ArrayList<>(ingredients);
            return list;
        }
        else
        {
            return new ArrayList<>();
        }
    }
}
