package com.tawseel.clients_server.table;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stores")
public class StoreDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "image_path")
    private String imagePath;
    //todo add the two columns
    @Column(name = "is_featured")
    private boolean isFeatured;
    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<StoreCoordinates> storeCoordinates;

    public StoreDetails() {
    }


    public StoreDetails(String name,
                        String phoneNumber,
                        String description,
                        String imagePath,
                        boolean isFeatured,
                        String category,
                        Set<StoreCoordinates> storeCoordinates) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.imagePath = imagePath;
        this.isFeatured = isFeatured;
        this.category = category;
        this.storeCoordinates = storeCoordinates;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean featured) {
        isFeatured = featured;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<StoreCoordinates> getStoreCoordinates() {
        return storeCoordinates;
    }

    public void setStoreCoordinates(Set<StoreCoordinates> storeCoordinates) {
        this.storeCoordinates = storeCoordinates;
    }

    @Override
    public String toString() {
        return "StoreDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", isFeatured=" + isFeatured +
                ", category='" + category + '\'' +
                ", storeCoordinates=" + storeCoordinates +
                '}';
    }
}
