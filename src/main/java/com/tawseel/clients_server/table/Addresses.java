package com.tawseel.clients_server.table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    @Column(name = "client_id")
    private int clientID;
}
