package com.tawseel.clients_server;

import com.tawseel.clients_server.db_classes.*;
import com.tawseel.clients_server.services.ItemService;
import com.tawseel.clients_server.services.OrderService;
import com.tawseel.clients_server.services.StoreDetailsService;
import com.tawseel.clients_server.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Test implements CommandLineRunner {
    @Autowired
    StoreService storeService;
    @Autowired
    OrderService orderService;
    @Autowired
    ItemService itemService;
    @Autowired
    StoreDetailsService storeDetailsService;

    @Override
    public void run(String... args) throws Exception {
       System.out.println(storeDetailsService.getAllStores());
    }
}
