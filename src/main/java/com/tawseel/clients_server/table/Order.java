package com.tawseel.clients_server.table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "comment")
    private String comment;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "tip")
    private int tip;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private Type paymentType;
    @Column(name = "clients_id")
    private int clientID;
}
