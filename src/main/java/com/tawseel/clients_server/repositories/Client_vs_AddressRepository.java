package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Client_vs_Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Client_vs_AddressRepository extends JpaRepository<Client_vs_Address,Integer> {
}
