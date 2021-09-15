package com.tawseel.clients_server.table.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "image_path")
    private String imagePath;
    //todo add the two columns
    @Column(name = "is_featured")
    private boolean isFeatured;
    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<StoreCoordinates> storeCoordinates;

    @OneToMany(mappedBy ="storeID", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<TimeSlot> schedule;

    public boolean isOpened(StoreDetails store)
    {
        return true;
    }
}
