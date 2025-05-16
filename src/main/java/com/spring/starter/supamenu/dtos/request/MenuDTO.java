package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.EMenu;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MenuDTO {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private EMenu type;

    private String pictures;
}