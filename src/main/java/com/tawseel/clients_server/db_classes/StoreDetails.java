package com.tawseel.clients_server.db_classes;

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
    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<StoreCoordinates> storeCoordinates;


    public StoreDetails(String name,
                        String phoneNumber, String description, String imagePath, boolean isFeatured) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.imagePath = imagePath;
        this.isFeatured = isFeatured;
    }

    public StoreDetails() {

    }

    public Set<StoreCoordinates> getStoreCoordinates() {
        return storeCoordinates;
    }

    public void setStoreCoordinates(Set<StoreCoordinates> storeCoordinates) {
        this.storeCoordinates = storeCoordinates;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", storeCoordinates=" + storeCoordinates +
                '}';
    }
}
