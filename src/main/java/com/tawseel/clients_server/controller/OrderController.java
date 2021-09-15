package com.tawseel.clients_server.controller;


import com.tawseel.clients_server.util.TemporaryOrder;
import com.tawseel.clients_server.security.TokensManager;
import com.tawseel.clients_server.table.order.Order;
import com.tawseel.clients_server.service.OrderService;
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

    @GetMapping("/purchaseHistory")
    public ResponseEntity<List<Order>> getPurchaseHistory(@RequestHeader("Authorization") String token)
    {
        Integer clientID = tokensManager.verifyToken(token);
        return new ResponseEntity<>(orderService.getPurchaseHistory(clientID), HttpStatus.OK);
    }

    @PostMapping("/addOrders")
    public ResponseEntity<Boolean> addOrder(@RequestHeader("Authorization") String token,@RequestBody List<TemporaryOrder> temporaryOrders)
    {
        Integer clientID = tokensManager.verifyToken(token);
        boolean succeed = orderService.addOrder(clientID, temporaryOrders);
        return new ResponseEntity<>(succeed, HttpStatus.OK);
    }
}
