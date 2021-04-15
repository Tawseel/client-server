package com.tawseel.clients_server.controllers;


import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.db_classes.Store;
import com.tawseel.clients_server.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private TokensManager tokensManager;
    @Autowired
    StoreService storeService;

    @GetMapping("/getAllStores")
    public ResponseEntity<List<Store>> getAllStores(@RequestHeader("Authorization") String  token)
    {
        Integer storeID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
    }
}
