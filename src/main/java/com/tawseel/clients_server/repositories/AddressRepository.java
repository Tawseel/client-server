package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, Integer> {
    Addresses findAddressesById(int id);
}
