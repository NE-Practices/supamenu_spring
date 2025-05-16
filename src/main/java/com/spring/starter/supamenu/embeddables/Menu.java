package com.spring.starter.supamenu.embeddables;

import com.spring.starter.supamenu.enums.EMenu;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private String name;
    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private EMenu type;

    private String pictures;

}