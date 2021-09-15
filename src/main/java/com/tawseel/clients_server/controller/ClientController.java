package com.tawseel.clients_server.controller;

import com.tawseel.clients_server.security.TokensManager;
import com.tawseel.clients_server.service.ClientService;
import com.tawseel.clients_server.table.client.Client;
import com.tawseel.clients_server.table.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final TokensManager tokensManager;
    private final ClientService clientService;

    @Autowired
    public ClientController(TokensManager tokensManager,
                            ClientService clientService) {
        this.tokensManager = tokensManager;
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Client> getClient(@RequestHeader("Authorization") String token) {
        Integer clientID = tokensManager.verifyToken(token);
        Client client = clientService.findClientById(clientID);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/updateClientDetails")
    public ResponseEntity<Boolean> updateClientDetails(@RequestHeader("Authorization") String token,
                                                       @RequestBody Client client) {
        tokensManager.verifyToken(token);
        boolean succeed = clientService.updateClientDetails(client);
        return new ResponseEntity<>(succeed, HttpStatus.OK);
    }

    @GetMapping("/recommendedItems")
    public ResponseEntity<List<Item>> getRecommendedItems(@RequestHeader("Authorization") String token) {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.getRecommendedItems(clientID), HttpStatus.OK);
    }
}
