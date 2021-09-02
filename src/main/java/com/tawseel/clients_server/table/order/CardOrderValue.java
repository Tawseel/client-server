package com.tawseel.clients_server.table.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card_order_value")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardOrderValue {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "card_order_id")
    private int cardOrderID;
}
