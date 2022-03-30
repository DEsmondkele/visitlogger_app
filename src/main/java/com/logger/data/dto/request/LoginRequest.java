package com.logger.data.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private Integer Id;
    private String email;
    private String passWord;
}
