package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateRestoDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String contactNumber;

    private ERestaurantType type;

    private ECuisine cuisineType;

    private List<String> pictures;
}
