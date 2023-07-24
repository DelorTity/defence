package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.service.SendMailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private SendMailsService sendMailsService;

    @GetMapping("/send-email")
    public void sendEmail() {
      String  to = "delortity@gmail.com";
      String  subject = "validation";
      String  text = "tout est ok";
        sendMailsService.sendSimpleMessage(to, subject, text);
    }
}
