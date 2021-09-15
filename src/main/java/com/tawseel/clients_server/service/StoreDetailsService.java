package com.tawseel.clients_server.service;

import com.tawseel.clients_server.table.store.StoreDetails;
import com.tawseel.clients_server.table.store.repository.StoreDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDetailsService {

    private final StoreDetailsRepository storeRepository;

    @Autowired
    public StoreDetailsService(StoreDetailsRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreDetails> getAllStores() {
        return storeRepository.findAll();
    }
}
