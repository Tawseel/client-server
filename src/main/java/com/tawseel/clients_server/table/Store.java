package com.tawseel.clients_server.table;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    private int id;
    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Item> items;

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
