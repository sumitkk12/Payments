package com.capstone.payments.controller;

import com.capstone.payments.serviceImpl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailServiceController {

    @Autowired
    private MailService senderService;
    @GetMapping("email/")
//    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        senderService.sendSimpleEmail("gauravkachare3@gmail.com",
                "Test",
                "Sub2");

    }
}


