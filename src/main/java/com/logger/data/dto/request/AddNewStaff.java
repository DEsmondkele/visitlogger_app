package com.logger.data.dto.request;

import lombok.Data;

@Data
public class AddNewStaff {
    private Integer id;
    private String staffName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String password;
}
