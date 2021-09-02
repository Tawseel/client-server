package com.tawseel.clients_server.services;

import com.tawseel.clients_server.table.Item;
import com.tawseel.clients_server.table.Store;
import com.tawseel.clients_server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    public List<Item> getItemsByStoreId(int storeId)
    {
        //better exception.
        Store store = storeRepository.findStoreById(storeId);
        if(store != null) {
            Set<Item> items = store.getItems();
            List<Item> list = new ArrayList<>(items);
            return list;
        }
        else
        {
            return new ArrayList<>();
        }
    }


}
