package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.table.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
