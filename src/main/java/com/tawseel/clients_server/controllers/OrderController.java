package com.tawseel.clients_server.controllers;


import com.tawseel.clients_server.TemporaryOrder;
import com.tawseel.clients_server.TokensManager;
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
    private TokensManager tokensManager;

    @GetMapping("/{id}/purchaseHistory")
    public ResponseEntity<List<Order>> getPurchaseHistoryByClientID(@PathVariable("id") int client_ID,
                                                                    @RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(orderService.getPurchaseHistory(client_ID), HttpStatus.OK);
    }

    @PostMapping("/addOrders")
    public boolean addOrder(@RequestHeader("Authorization") String token, List<TemporaryOrder> temporaryOrders)
    {
        Integer userID = tokensManager.verifyToken(token);
        boolean succeed = orderService.addOrder(userID, temporaryOrders);
        return succeed;
    }
}
