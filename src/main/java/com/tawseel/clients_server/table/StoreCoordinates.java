package com.tawseel.clients_server.table;

import javax.persistence.*;

@Entity
@Table(name = "store_coordinates")
public class StoreCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "stores_id")
    private int storeID;
    //todo: need to add address.

    public StoreCoordinates(String longitude, String latitude, int storeID) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.storeID = storeID;
    }

    public StoreCoordinates() {

    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "StoreCoordinates{" +
                "id=" + id +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", storeID=" + storeID +
                '}';
    }
}
