package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.services.ClientService;
import com.tawseel.clients_server.table.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private TokensManager tokensManager;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Client> getItemByStoreID(@RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.findClientById(clientID), HttpStatus.OK);
    }
}
