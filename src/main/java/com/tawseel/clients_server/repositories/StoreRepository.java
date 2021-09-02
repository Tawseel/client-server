package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById (int id);
}
