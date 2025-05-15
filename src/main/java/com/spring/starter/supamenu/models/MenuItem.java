package com.spring.starter.supamenu.models;

import com.spring.starter.supamenu.enums.EMenu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_items")
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private EMenu type;

    @ElementCollection
    private List<String> pictures;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Resto restaurant;


    public MenuItem(String name, String description, BigDecimal price, EMenu type, List<String> pictures) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.pictures = pictures;
    }
}
