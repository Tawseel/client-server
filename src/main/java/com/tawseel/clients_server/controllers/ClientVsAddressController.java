package com.tawseel.clients_server.controllers;

import com.tawseel.clients_server.services.ClientVsAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientVsAddress")
public class ClientVsAddressController {
    @Autowired
    ClientVsAddressService client_vs_addressService;
}
