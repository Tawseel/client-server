package com.tawseel.clients_server.table.store.repository;

import com.tawseel.clients_server.table.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreById (int id);
}
