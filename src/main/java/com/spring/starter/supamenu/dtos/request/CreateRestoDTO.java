package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.ECuisine;
import com.spring.starter.supamenu.enums.ERestaurantType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.util.List;

@Data

public class CreateRestoDTO {
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "[0-9]{9,12}", message = "Your phone is not a valid tel we expect 2507***, or 07*** or 7***")
    private String contactNumber;

    private ERestaurantType type;

    private ECuisine cuisineType;

    private List<String> pictures;
}
