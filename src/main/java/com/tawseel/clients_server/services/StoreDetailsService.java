package com.tawseel.clients_server.services;

import com.tawseel.clients_server.table.StoreDetails;
import com.tawseel.clients_server.repositories.StoreDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreDetailsService {
    @Autowired
    StoreDetailsRepository storeRepository;

    public List<StoreDetails> getAllStores()
    {

        return storeRepository.findAll();
    }
}
