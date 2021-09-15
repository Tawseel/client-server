package com.tawseel.clients_server.controller;


import com.tawseel.clients_server.security.TokensManager;
import com.tawseel.clients_server.table.ingredient.Ingredients;
import com.tawseel.clients_server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final TokensManager tokensManager;

    @Autowired
    public ItemController(ItemService itemService,
                          TokensManager tokensManager) {
        this.itemService = itemService;
        this.tokensManager = tokensManager;
    }

    @GetMapping("/{id}/ingredients")
    public ResponseEntity<List<Ingredients>> getIngredientsByItemID(@PathVariable("id") int itemID,
                                                                    @RequestHeader("Authorization") String token) {
        tokensManager.verifyToken(token);
        return new ResponseEntity<>(itemService.getIngredientsByItemID(itemID), HttpStatus.OK);
    }
}
