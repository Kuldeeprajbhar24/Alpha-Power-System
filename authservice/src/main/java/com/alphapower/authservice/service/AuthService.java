package com.alphapower.authservice.service;

import com.alphapower.authservice.dto.*;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
    void changePassword(String email, ChangePasswordRequest request);
}