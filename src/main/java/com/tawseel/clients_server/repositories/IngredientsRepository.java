package com.tawseel.clients_server.repositories;

import com.tawseel.clients_server.db_classes.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
