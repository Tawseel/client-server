package com.tawseel.clients_server.table.ingredient.repository;

import com.tawseel.clients_server.table.ingredient.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
