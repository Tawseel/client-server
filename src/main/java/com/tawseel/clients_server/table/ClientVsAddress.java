package com.tawseel.clients_server.table;

import javax.persistence.*;

@Entity
@Table(name = "clients_vs_addresses")
public class ClientVsAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    private int address_id;

    public ClientVsAddress() {
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

    @Override
    public String toString() {
        return "ClientVsAddress{" +
                "client_id=" + client_id +
                ", address_id=" + address_id +
                '}';
    }
}
