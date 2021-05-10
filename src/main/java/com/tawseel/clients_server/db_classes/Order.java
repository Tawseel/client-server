package com.tawseel.clients_server.db_classes;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "comment")
    private String comment;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "tip")
    private int tip;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private Type paymentType;
    @Column(name = "clients_id")
    private int clientID;


    public Order(LocalDateTime dateTime, String comment, int totalPrice, int tip,
                 Type paymentType, int clientId) {
        this.dateTime = dateTime;
        this.comment = comment;
        this.totalPrice = totalPrice;
        this.tip = tip;
        this.paymentType = paymentType;
        this.clientID = clientId;
    }

    public Order() {

    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public Type getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Type paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", comment='" + comment + '\'' +
                ", totalPrice=" + totalPrice +
                ", tip=" + tip +
                ", paymentType=" + paymentType +
                ", clientID=" + clientID +
                '}';
    }
}
