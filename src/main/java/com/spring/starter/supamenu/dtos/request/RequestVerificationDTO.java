package com.spring.starter.supamenu.dtos.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RequestVerificationDTO {

    @Email
    private String email;

}
