package com.tawseel.clients_server.services;

import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.db_classes.Store;
import com.tawseel.clients_server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    public List<Store> getAllStores()
    {
        List<Store> list = storeRepository.findAll();
        return list;
    }
}
