package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.services.Client_vs_AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientVsAddress")
public class Client_vs_AddressController {
    @Autowired
    Client_vs_AddressService client_vs_addressService;
}
