package com.tawseel.clients_server.table.item;

import com.tawseel.clients_server.table.ingredient.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "store_id")
    private int storeID;

    @OneToMany(mappedBy ="itemID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Ingredients> ingredients;

    @Column(name = "image_path")
    private String imagePath;
}
