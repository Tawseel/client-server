package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.ClientVsAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientVsAddressRepository extends JpaRepository<ClientVsAddress,Integer> {
}
