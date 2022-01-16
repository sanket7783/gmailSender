package com.springBootLearning.gmailSender.service.Impl;

import com.springBootLearning.gmailSender.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Your_Email");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);


        mailSender.send(message);
        System.out.println("Email Sent...........");
    }
}
