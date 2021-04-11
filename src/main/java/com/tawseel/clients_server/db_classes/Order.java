package com.tawseel.clients_server.db_classes;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_time")
    private Date dateTime;
    @Column(name = "comment")
    private String comment;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "tip")
    private int tip;
    @Column(name = "order_type")
    private int orderType;
    @Column(name = "payment_type")
    private int paymentType;
    @Column(name = "client_id")
    private int clientId;

    public Order(Date dateTime, String comment, int totalPrice, int tip, int orderType, int paymentType, int clientId) {
        this.dateTime = dateTime;
        this.comment = comment;
        this.totalPrice = totalPrice;
        this.tip = tip;
        this.orderType = orderType;
        this.paymentType = paymentType;
        this.clientId = clientId;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
