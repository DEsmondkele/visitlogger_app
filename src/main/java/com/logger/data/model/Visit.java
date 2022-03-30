package com.logger.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Visit {

    @Id
    private Integer id;
    private LocalDateTime dateOfVisit;

    private Integer visitorId;
    private String name;
    private  String purposeOfVisit;
    private Integer staffId;
}
