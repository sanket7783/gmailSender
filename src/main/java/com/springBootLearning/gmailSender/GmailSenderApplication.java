package com.springBootLearning.gmailSender;

import com.springBootLearning.gmailSender.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class GmailSenderApplication {

	@Autowired
	private EmailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(GmailSenderApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		emailSender.sendMail("your_email",
				"This is subject", "This is body",
				"/home/test/Downloads/sqlErrrorVA2QA.png");
	}

}
