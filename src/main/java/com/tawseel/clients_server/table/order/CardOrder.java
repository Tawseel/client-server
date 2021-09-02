package com.tawseel.clients_server.table.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "card_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardOrder {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "user_id")
    private int userId;

    @OneToMany(mappedBy ="cardOrderID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<CardOrderValue> cardOrderValueList;
}
