package com.tawseel.clients_server.services;

import com.tawseel.clients_server.repositories.ClientVsAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientVsAddressService {
    @Autowired
    ClientVsAddressRepository client_vs_addressRepository;
}
