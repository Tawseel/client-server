package com.tawseel.clients_server.table.client.repository;

import com.tawseel.clients_server.table.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById (Integer clientId);
}
