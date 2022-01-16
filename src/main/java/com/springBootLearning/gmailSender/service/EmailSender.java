package com.springBootLearning.gmailSender.service;

import javax.mail.MessagingException;

public interface EmailSender {

    void sendMail(String toEmail, String subject, String body);

    void sendMail(String toEmail, String subject, String body, String attachment) throws MessagingException;
}
