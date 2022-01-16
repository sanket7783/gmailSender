package com.springBootLearning.gmailSender.service;

public interface EmailSender {

    void sendMail(String toEmail, String subject, String body);
}
