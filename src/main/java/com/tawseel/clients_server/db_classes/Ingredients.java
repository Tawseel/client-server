package com.tawseel.clients_server.db_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_id")
    private int itemID;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @OneToMany(mappedBy = "ingredientID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Value> values;

    @OneToMany(mappedBy ="ingredientID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<IngredientConfiguration> ingredientConfiguration;
}