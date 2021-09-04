package com.tawseel.clients_server;

import com.tawseel.clients_server.table.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StatusUpdate {
    private int orderID;
    private OrderStatus orderStatus;
}
