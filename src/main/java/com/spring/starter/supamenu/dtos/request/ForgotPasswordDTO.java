package com.spring.starter.supamenu.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ForgotPasswordDTO {
    @NotBlank
    private String email;
}
