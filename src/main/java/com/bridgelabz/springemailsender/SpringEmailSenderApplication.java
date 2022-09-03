package com.bridgelabz.springemailsender;

import com.bridgelabz.springemailsender.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailSenderApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailSenderApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() throws MessagingException {
        emailSenderService.sendSimpleEmail("roshni.mali@bridgelabz.com",
                "Email Sender Project",
                "Hello Roshni");

    }
}
