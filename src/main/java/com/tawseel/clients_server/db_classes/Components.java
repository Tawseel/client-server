package com.tawseel.clients_server.db_classes;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "components")
public class Components extends ArrayList<CustomizedComponent> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "items_id")
    private int itemID;

    public Components(int itemID) {
        this.itemID = itemID;
    }

    public Components() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "Component{" +
                "super class{" + super.toString() +
                "id=" + id +
                ", itemID=" + itemID +
                '}';
    }
}
