package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.StoreDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDetailsRepository extends JpaRepository<StoreDetails,Integer> {
    StoreDetails findStoreDetailsById (int id);
}
