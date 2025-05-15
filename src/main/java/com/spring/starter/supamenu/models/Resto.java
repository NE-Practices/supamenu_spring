package com.spring.starter.supamenu.models;

import com.spring.starter.supamenu.audits.TimestampAudit;
import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurants")
@Data
public class Resto extends TimestampAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String name;

    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private ERestaurantType type;

    @Enumerated(EnumType.STRING)
    private ECuisine cuisineType;

    @ElementCollection
    private List<String> pictures;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menu;

    public Resto(String name, String contactNumber, ECuisine cuisineType, ERestaurantType type, List<String> pictures) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.cuisineType = cuisineType;
        this.type = type;
        this.pictures = pictures;
    }


}
