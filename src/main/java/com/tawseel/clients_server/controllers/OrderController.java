package com.tawseel.clients_server.controllers;


import com.tawseel.clients_server.StatusUpdate;
import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.services.ClientService;
import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Order;
import com.tawseel.clients_server.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ClientService clientService;
    @Autowired
    private TokensManager tokensManager;

    @GetMapping("/purchaseHistory")
    public ResponseEntity<List<Order>> getPurchaseHistory(@RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        Client client = clientService.findClientById(clientID);
        return new ResponseEntity<>(orderService.getPurchaseHistory(client), HttpStatus.OK);
    }

    @PostMapping("/addOrders")
    public ResponseEntity<Boolean> addOrder(@RequestHeader("Authorization") String token,@RequestBody List<TemporaryOrder> temporaryOrders)
    {
        Integer clientID = tokensManager.verifyToken(token);
        boolean succeed = orderService.addOrder(clientID, temporaryOrders);
        return new ResponseEntity<>(succeed, HttpStatus.OK);
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<Boolean> updateOrderStatus(@RequestHeader("Authorization") String token, @RequestBody StatusUpdate statusUpdate)
    {
        boolean succeed = orderService.updateOrderStatus(statusUpdate);
        return new ResponseEntity<>(succeed, HttpStatus.OK);
    }
}
