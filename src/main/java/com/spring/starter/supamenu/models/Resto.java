package com.spring.starter.supamenu.models;

import com.spring.starter.supamenu.audits.TimestampAudit;
import com.spring.starter.supamenu.embeddables.Menu;
import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @ElementCollection
    @CollectionTable(name = "resto_menus", joinColumns = @JoinColumn(name = "resto_id"))
    private List<Menu> menus = new ArrayList<>();

    public Resto(String name, String contactNumber, ECuisine cuisineType, ERestaurantType type, List<String> pictures, List<Menu> menus) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.cuisineType = cuisineType;
        this.type = type;
        this.pictures = pictures;
        this.menus = menus != null ? menus : new ArrayList<>();
    }
}