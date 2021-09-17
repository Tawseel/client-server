package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.store.Store;
import com.tawseel.clients_server.table.store.StoreDetails;
import com.tawseel.clients_server.table.store.repository.StoreDetailsRepository;
import com.tawseel.clients_server.table.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreDetailsRepository storeDetailsRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository,
                        StoreDetailsRepository storeDetailsRepository) {
        this.storeRepository = storeRepository;
        this.storeDetailsRepository = storeDetailsRepository;
    }

    public List<Item> getItemsByStoreId(Integer storeId) {
        Store store = storeRepository.findStoreById(storeId);
        return store != null ? new ArrayList<>(store.getItems()) : new ArrayList<>();
    }

    public List<StoreDetails> getAllStores() {
        return storeDetailsRepository.findAll();
    }
}
