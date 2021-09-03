package com.tawseel.clients_server.table;

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

    @Column(name = "title")
    private String title;

    @Column(name = "item_id")
    private int itemID;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @OneToMany(mappedBy ="ingredientID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Value> values;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "config_id", referencedColumnName = "id")
    private IngredientConfiguration ingredientConfiguration;
}
