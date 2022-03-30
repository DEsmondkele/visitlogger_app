package com.logger.data.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private LoginStatus message;

    public LoginResponse(LoginStatus successful) {

    }
}
