package com.tawseel.clients_server.table;


import javax.persistence.*;

@Entity
@Table(name ="addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "home_number")
    private String homeNumber;
    @Column(name = "floor_number")
    private String floorNumber;

    public Addresses(String streetName, String streetNumber, String homeNumber, String floorNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.homeNumber = homeNumber;
        this.floorNumber = floorNumber;
    }

    public Addresses() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }
}
