package com.logger.services.mail;

import com.logger.data.model.Visit;

import javax.mail.MessagingException;

public interface EmailServices {
    MailResponse send(String to, String subject, Visit newVisit) throws MessagingException;
    void sendPreConfigMail(String message);
}
