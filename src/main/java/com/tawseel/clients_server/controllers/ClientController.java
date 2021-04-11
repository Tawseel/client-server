package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/getAllClients")
    public List<Client> getAllClients()
    {
        return clientService.getAllClients();
    }
    @PostMapping("/addClient")
    public void addClientToDB(Client client)
    {
        clientService.addClientToDB(client);
    }
}
