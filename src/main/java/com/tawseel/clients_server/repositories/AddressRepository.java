package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, Integer> {
}
