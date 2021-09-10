package com.tawseel.clients_server.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "stores")
public class Store {
    @Id
    private int id;
    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Item> items;
}
