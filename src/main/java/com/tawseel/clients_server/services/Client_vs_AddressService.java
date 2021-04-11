package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.Client_vs_AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Client_vs_AddressService {
    @Autowired
    Client_vs_AddressRepository client_vs_addressRepository;
}
