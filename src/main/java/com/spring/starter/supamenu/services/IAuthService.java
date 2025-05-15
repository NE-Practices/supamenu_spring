package com.spring.starter.supamenu.services;


import com.spring.starter.supamenu.dtos.response.JwtAuthenticationResponse;

public interface IAuthService {
    JwtAuthenticationResponse login(String email, String password);

    void initiateResetPassword(String email);

    void resetPassword(String email, String passwordResetCode, String newPassword);
    void initiateAccountVerification(String email);
    void verifyAccount(String activationCode);
}
