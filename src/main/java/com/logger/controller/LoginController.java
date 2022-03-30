package com.logger.controller;

import com.logger.data.dto.request.LoginRequest;
import com.logger.data.dto.response.LoginResponse;
import com.logger.services.LoginServices;
import com.logger.services.LoginServicesImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
public class LoginController {
    public final LoginServices loginServices= new LoginServicesImpl();
    @PostMapping("login/visitor")
    public LoginResponse loginVisitor(LoginRequest request) throws LoginException {
        return loginServices.visitorLogin(request);
    }
    @PostMapping("login/staff")
    public LoginResponse loginStaff(LoginRequest request) throws LoginException {
        return loginServices.staffLogin(request);
    }
}
