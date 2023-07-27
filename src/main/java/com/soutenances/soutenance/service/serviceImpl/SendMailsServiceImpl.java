package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.SendMailsService;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailsServiceImpl implements SendMailsService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
