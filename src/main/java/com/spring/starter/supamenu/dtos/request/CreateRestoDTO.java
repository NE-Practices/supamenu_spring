package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import com.spring.starter.supamenu.embeddables.Menu;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestoDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String contactNumber;

    @NotNull
    private ECuisine cuisineType;

    @NotNull
    private ERestaurantType type;

    private List<String> pictures;

    private List<Menu> menus;
}