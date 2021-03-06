package com.tawseel.clients_server.table.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "points")
    private int points;
    @OneToMany(mappedBy ="clientID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<Addresses> addresses;

    @Column(name = "default_Address_id")
    private Integer defaultAddressId;

    @Transient
    private Addresses defaultAddress;
}
