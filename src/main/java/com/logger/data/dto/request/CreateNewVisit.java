package com.logger.data.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateNewVisit {

    private  Integer visitId;
    private LocalDateTime dateOfVisit;
    private  Integer visitorId;
    private String name;
    private String purposeOfVisit;
}
