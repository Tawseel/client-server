package com.tawseel.clients_server.table.store.repository;

import com.tawseel.clients_server.table.store.StoreDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDetailsRepository extends JpaRepository<StoreDetails,Integer> {
    StoreDetails findStoreDetailsById (int id);
}
