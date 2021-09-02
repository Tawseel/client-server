package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.services.ClientService;
import com.tawseel.clients_server.table.Ingredients;
import com.tawseel.clients_server.table.order.CardOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private TokensManager tokensManager;
    @Autowired
    ClientService clientService;

    @PostMapping("/addToCard")
    public ResponseEntity<Boolean> getIngredientsByItemID(@RequestBody CardOrder cardOrder,
                                                                    @RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.addOrderToCard(clientID, cardOrder), HttpStatus.OK);
    }

}
