package com.logger.data.dto.response;

import lombok.Data;

@Data
public class FindVisitorResponse {
    private String visitorName;
    private Integer visitorId;
    private String phoneNumber;
    private String address;
    private String email;
}
