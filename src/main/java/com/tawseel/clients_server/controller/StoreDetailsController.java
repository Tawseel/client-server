package com.tawseel.clients_server.controller;


import com.tawseel.clients_server.security.TokensManager;
import com.tawseel.clients_server.table.store.StoreDetails;
import com.tawseel.clients_server.service.StoreDetailsService;
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
public class StoreDetailsController {

    private final TokensManager tokensManager;
    private final StoreDetailsService storeDetailsService;

    @Autowired
    public StoreDetailsController(TokensManager tokensManager,
                                  StoreDetailsService storeDetailsService) {
        this.tokensManager = tokensManager;
        this.storeDetailsService = storeDetailsService;
    }

    @GetMapping("/getAllStores")
    public ResponseEntity<List<StoreDetails>> getAllStores(@RequestHeader("Authorization") String  token)
    {
        tokensManager.verifyToken(token);
        return new ResponseEntity<>(storeDetailsService.getAllStores(), HttpStatus.OK);
    }
}
