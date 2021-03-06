package com.tawseel.clients_server.table.ingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "ingredient_value")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "ingredient_id")
    private int ingredientID;
}
