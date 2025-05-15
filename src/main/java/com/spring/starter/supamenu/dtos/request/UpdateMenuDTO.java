package com.spring.starter.supamenu.dtos.request;

import com.spring.starter.supamenu.enums.EMenu;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;


@Getter
public class UpdateMenuDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;

    private EMenu type;

    private List<String> pictures;
}
