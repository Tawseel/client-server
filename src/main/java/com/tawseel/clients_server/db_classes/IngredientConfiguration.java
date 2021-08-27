package com.tawseel.clients_server.db_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "ingredient_configuration")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="minimum_value")
    private int minimumValue;

    @Column(name="maximum_value")
    private int maximumValue;

    @Column(name="step")
    private int step;

    @Column(name = "ingredient_id")
    private int ingredientID;

}
