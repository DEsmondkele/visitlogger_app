package com.logger.data.dto.request;

import lombok.Data;

@Data
public class AddNewVisitor {

    private Integer id;
    private String visitorName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String password;
}
