package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.EMenu;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;


@Data
public class CreateMenuDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;


    private EMenu type;

    @Nullable
    private List<String> pictures;
}
