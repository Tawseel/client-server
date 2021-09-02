package com.tawseel.clients_server.table;


import com.tawseel.clients_server.table.order.CardOrderValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "item_id")
    private int itemId;
    @OneToMany(mappedBy ="cardOrderID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<CardOrderValue> cardOrderValueList;
}
