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
                "Payment Pending",
                "Your payment is pending of Rs."+ "1000"+" of biller" +"Jio"+" Due Date is" + " 12/02/2022");

    }
    @GetMapping("emaildone/")
//    @EventListener(ApplicationReadyEvent.class)
     public void paymentdone() throws MessagingException {
        senderService.sendSimpleEmail("gauravkachare3@gmail.com",
                "Payment Made",
                "Your payment of Rs."+ "1000"+" is made to " +"Jio"+" On Date " + " 12/02/2022");

    }
}


