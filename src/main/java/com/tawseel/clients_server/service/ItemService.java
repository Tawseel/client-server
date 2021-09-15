package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.ingredient.Ingredients;
import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Ingredients> getIngredientsByItemID(Integer itemID)
    {
        Item item = itemRepository.findItemById(itemID);
        if(item != null) {
            Set<Ingredients> ingredients = item.getIngredients();
            return new ArrayList<>(ingredients);
        }
        else
        {
            return new ArrayList<>();
        }
    }
}
