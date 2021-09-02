package com.tawseel.clients_server.table;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "amount_paid")
    private int amountPaid;

    public Payment(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Payment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
