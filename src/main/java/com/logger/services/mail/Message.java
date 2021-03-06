package com.logger.services.mail;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String to;
    private String body;
    private String subject;
    private String from;
}
