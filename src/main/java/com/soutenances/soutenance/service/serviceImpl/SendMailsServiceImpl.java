package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.SendMailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailsServiceImpl implements SendMailsService {
    @Autowired
    private JavaMailSender javaMailSender;
    /*@Autowired
    private User user;*/
    /*@Autowired*/
    /*private DefenseDto defenseDto;*/

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        User user = new User();
        DefenseDto defenseDto = new DefenseDto();

        to = user.getEmail();
        subject = "Confirmation de la soutenance";
        text = "vous soutenez le " + defenseDto.getDate() + " a " + defenseDto.getTime() + "dans la salle " + defenseDto.getClassroom();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
