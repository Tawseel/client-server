package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById (int clientId);
}
