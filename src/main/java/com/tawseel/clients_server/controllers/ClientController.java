package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.services.ClientService;
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
    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients(@RequestHeader("Authorization") String  token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
    @PostMapping("/addClient")
    public void addClientToDB(Client client)
    {
        clientService.addClientToDB(client);
    }

}
