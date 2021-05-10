package com.tawseel.clients_server.db_classes;


import java.io.Serializable;
import java.util.Objects;

public class DoublePrimaryKey implements Serializable {
    private int orderID;
    private int itemID;

    public DoublePrimaryKey(int orderID, int itemID) {
        this.orderID = orderID;
        this.itemID = itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublePrimaryKey that = (DoublePrimaryKey) o;
        return orderID == that.orderID && itemID == that.itemID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, itemID);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "DoublePrimaryKey{" +
                "orderID=" + orderID +
                ", itemID=" + itemID +
                '}';
    }
}
