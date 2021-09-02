package com.tawseel.clients_server.controllers;


import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.table.Ingredients;
import com.tawseel.clients_server.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    private TokensManager tokensManager;


    @GetMapping("/{id}/ingredients")
    public ResponseEntity<List<Ingredients>> getIngredientsByItemID(@PathVariable("id") int itemID,
                                                                    @RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(itemService.getIngredientsByItemID(itemID), HttpStatus.OK);
    }
}
