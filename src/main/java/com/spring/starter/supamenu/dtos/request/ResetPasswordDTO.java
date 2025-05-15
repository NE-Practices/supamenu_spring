package com.spring.starter.supamenu.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ResetPasswordDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String passwordResetCode;
    @NotBlank
    private String newPassword;
}
