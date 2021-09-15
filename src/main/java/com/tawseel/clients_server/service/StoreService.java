package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.store.Store;
import com.tawseel.clients_server.table.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Item> getItemsByStoreId(Integer storeId) {
        Store store = storeRepository.findStoreById(storeId);
        return store != null ? new ArrayList<>(store.getItems()) : new ArrayList<>();
    }
}
