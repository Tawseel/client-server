package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.services.ClientService;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Item;
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
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Client> getClient(@RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.findClientById(clientID), HttpStatus.OK);
    }

    @PutMapping("/updateClientDetails")
    public ResponseEntity<Boolean> updateClientDetails(@RequestHeader("Authorization") String token,
                                       @RequestBody Client client)
    {
        Integer clientID = tokensManager.verifyToken(token);
        boolean succeed = clientService.updateClientDetails(client);
        return new ResponseEntity<>(succeed, HttpStatus.OK);
    }

    @GetMapping("/recommendedItems")
    public ResponseEntity<List<Item>> getRecommendedItems(@RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.getRecommendedItems(clientID), HttpStatus.OK);
    }
}
