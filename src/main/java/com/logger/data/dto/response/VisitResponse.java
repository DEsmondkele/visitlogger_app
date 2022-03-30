package com.logger.data.dto.response;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class VisitResponse {
    private  Integer visitorId;
    private LocalDateTime dateOfVisit;
    private String visitorName;
    private String email;
    private String purposeOfVisit;
}
