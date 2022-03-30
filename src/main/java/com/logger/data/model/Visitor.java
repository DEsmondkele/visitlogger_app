package com.logger.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Visitor {
    @Id
    private Integer id;

    private String visitorName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String password;
    @Override
    public  String toString(){
        return getId().toString();
    }
}
