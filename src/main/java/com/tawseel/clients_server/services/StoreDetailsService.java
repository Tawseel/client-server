package com.tawseel.clients_server.services;

import com.tawseel.clients_server.db_classes.Item;
import com.tawseel.clients_server.db_classes.StoreDetails;
import com.tawseel.clients_server.repositories.StoreDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StoreDetailsService {
    @Autowired
    StoreDetailsRepository storeRepository;

    public List<StoreDetails> getAllStores()
    {

        List<StoreDetails> list = storeRepository.findAll();
        return list;
    }
}
