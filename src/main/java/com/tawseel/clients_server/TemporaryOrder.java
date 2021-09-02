package com.tawseel.clients_server;

import com.tawseel.clients_server.table.Item;

import java.util.HashMap;

public class TemporaryOrder {
    private Item item;
    private HashMap<String, String> values;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }
}
