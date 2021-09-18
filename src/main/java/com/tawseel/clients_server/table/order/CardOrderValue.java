package com.tawseel.clients_server.table.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "card_order_value")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardOrderValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "ingredient_value")
    private String ingredientValue;

    @Column(name = "order_id")
    private int orderID;

    @Column(name = "price")
    private int price;
}
