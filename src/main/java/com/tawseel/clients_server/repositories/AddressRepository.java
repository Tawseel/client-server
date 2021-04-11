package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
