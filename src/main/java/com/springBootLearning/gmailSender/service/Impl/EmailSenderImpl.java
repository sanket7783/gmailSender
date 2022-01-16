package com.springBootLearning.gmailSender.service.Impl;

import com.springBootLearning.gmailSender.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your_email");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);


        mailSender.send(message);
        System.out.println("Email Sent...........");
    }

    public void sendMail(String toEmail, String body,
                                       String subject, String Attachment) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom("your_email");
        mimeMessageHelper.setTo("your_email");
        mimeMessageHelper.setText("This is body");
        mimeMessageHelper.setSubject("this is subject");
        FileSystemResource fileSystemResource = new FileSystemResource(new File(Attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
                fileSystemResource);
        mailSender.send(message);
        System.out.println("Mail Sent........");
    }
}
