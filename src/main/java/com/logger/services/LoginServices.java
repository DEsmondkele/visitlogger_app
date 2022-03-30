package com.logger.services;

import com.logger.data.dto.request.LoginRequest;
import com.logger.data.dto.response.LoginResponse;

import javax.security.auth.login.LoginException;

public interface LoginServices {
    LoginResponse visitorLogin(LoginRequest request) throws LoginException;
    LoginResponse staffLogin(LoginRequest loginRequest)throws LoginException;
}
