package com.tawseel.clients_server.db_classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Items")
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
    private Set<Components> components;
    @Column(name = "image_path")
    private String imagePath;

    public Item(String name, String description, int price, String category, int storeID, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.storeID = storeID;
        this.imagePath = imagePath;
    }

    public Item() {

    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Components> getComponents() {
        return components;
    }

    public void setComponents(Set<Components> components) {
        this.components = components;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", storeID=" + storeID +
                '}';
    }
}
