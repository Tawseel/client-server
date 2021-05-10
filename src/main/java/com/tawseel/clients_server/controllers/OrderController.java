package com.tawseel.clients_server.controllers;


import com.tawseel.clients_server.TokensManager;
import com.tawseel.clients_server.db_classes.Client;
import com.tawseel.clients_server.db_classes.Item;
import com.tawseel.clients_server.db_classes.Order;
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
    private TokensManager tokensManager;

    @GetMapping("/{id}/purchaseHistory")
    public ResponseEntity<List<Order>> getPurchaseHistoryByClientID(@PathVariable("id") int client_ID,
                                                                    @RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(orderService.getPurchaseHistory(client_ID), HttpStatus.OK);
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestHeader("Authorization") String token, Order order)
    {
        Integer clientID = tokensManager.verifyToken(token);
        orderService.addOrder(clientID, order);
    }
}
