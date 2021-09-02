package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payment,Integer> {
}
