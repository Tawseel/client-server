package com.tawseel.clients_server.util;

import com.tawseel.clients_server.table.item.Item;
import com.tawseel.clients_server.table.order.CardOrderValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TemporaryOrder {
    private Item item;
    private int totalPrice;
    private List<CardOrderValue> values;
}
