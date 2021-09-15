package com.tawseel.clients_server.controller;

import com.tawseel.clients_server.security.TokensManager;
import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    private TokensManager tokensManager;

    @GetMapping("/{id}/items")
    public ResponseEntity<List<Item>> getItemByStoreID(@PathVariable("id") int storeID,
                                                       @RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(storeService.getItemsByStoreId(storeID), HttpStatus.OK);
    }
}
