package com.tawseel.clients_server.db_classes;

import javax.persistence.*;

@Entity
@Table(name = "clients_vs_addresses")
public class Client_vs_Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    private int address_id;

    public Client_vs_Address() {
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
