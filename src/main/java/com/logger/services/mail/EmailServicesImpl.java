package com.logger.services.mail;

import com.logger.data.model.Visit;
import com.logger.repository.VisitRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmailServicesImpl implements EmailServices {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SimpleMailMessage preConfigMessage;
    @Autowired
    private VisitRepo repo;
    @Override
    public MailResponse send(String to, String subject, Visit newVisit) throws MessagingException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        newVisit = (Visit) repo.findAll();
        mailMessage.setText(newVisit.toString());
        mailSender.send(mailMessage);
        return new MailResponse(true);
    }
    @Override
    public  void sendPreConfigMail(String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfigMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
