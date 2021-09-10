package com.tawseel.clients_server.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "timeslot")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "store_id")
    private int storeID;

    @Column(name="day")
    @Enumerated(EnumType.STRING)
    private Days day;

    @Column(name="hour")
    private int hour; // 00 -> 23
}