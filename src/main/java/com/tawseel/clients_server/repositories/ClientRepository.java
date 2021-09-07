package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Client;
import com.tawseel.clients_server.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById (Integer clientId);
}
