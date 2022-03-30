package com.logger.utilities.exception;

import com.logger.data.model.Staff;
import com.logger.data.model.Visit;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
@AllArgsConstructor
@Configuration
public class EmailConfig {
    public final Visit visit;
    public final Staff staff;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);
        mailSender.setUsername("admin@gmail.com");
        mailSender.setPassword("password");
            Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
    @Bean
    public SimpleMailMessage emailTemplate() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(staff.getEmailAddress());
        message.setFrom("admin@gmail.com");
        message.setText("you have a message from: " +visit.getName()+" message: "+visit.getPurposeOfVisit());
                return message;
    }
}
