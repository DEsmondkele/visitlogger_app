package com.logger.data.model;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Staff {
    @Id
    private Integer id;
    private String staffName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String password;
}
