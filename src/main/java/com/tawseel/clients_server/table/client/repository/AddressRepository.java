package com.tawseel.clients_server.table.client.repository;

import com.tawseel.clients_server.table.client.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, Integer> {
    Addresses findAddressesById(int id);
}
