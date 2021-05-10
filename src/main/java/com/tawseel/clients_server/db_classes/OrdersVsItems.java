package com.tawseel.clients_server.db_classes;


import javax.persistence.*;

@Entity
@IdClass(DoublePrimaryKey.class)
@Table(name = "orders_vs_items")
public class OrdersVsItems {
    @Id
    @Column(name = "orders_id")
    private int orderID;
    @Id
    @Column(name = "items_id")
    private int itemID;

    public OrdersVsItems(int ordersID, int itemsID) {
        this.orderID = ordersID;
        this.itemID = itemsID;
    }

    public OrdersVsItems() {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int ordersID) {
        this.orderID = ordersID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemsID) {
        this.itemID = itemsID;
    }

    @Override
    public String toString() {
        return "OrdersVsItems{" +
                "orderID=" + orderID +
                ", itemID=" + itemID +
                '}';
    }
}
