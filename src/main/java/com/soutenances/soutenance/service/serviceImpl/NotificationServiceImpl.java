package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.repository.UserRepository;
import com.soutenances.soutenance.service.NotificationService;
import com.soutenances.soutenance.service.SendMailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private SendMailsService sendMailsService;
    @Autowired
    private UserRepository userRepository;

    public void SentNotificationMail(DefenseDto defenseDto) {

        User student = userRepository.findById(defenseDto.getStudent()).get();
        User jury = userRepository.findById(defenseDto.getJury1()).get();
        User jury2 = userRepository.findById(defenseDto.getJury2()).get();

        String text = "Soutenances IUT  M/Mlle/Mme " +  jury.getFirstName()  + " " + jury.getLastName() + " vous fait partir du jury des soutenances prevue le " + defenseDto.getDate() + " a " + defenseDto.getTime() + " dans la salle " + defenseDto.getClassroom();
        String text1 = "Soutenances IUT  M/Mlle/Mme " +  jury.getFirstName()  + " " + jury.getLastName() + " vous fait partir du jury des soutenances prevue le  " + defenseDto.getDate() + " a " + defenseDto.getTime() + " dans la salle " + defenseDto.getClassroom();
        String text2 = "Soutenances IUT  M/Mlle/Mme " +  student.getFirstName()  + " " + student.getLastName() + " vous soutenez le  " + defenseDto.getDate() + " a " + defenseDto.getTime() + " dans la salle " + defenseDto.getClassroom() + "Avec pour jury  president: " +
                jury.getFirstName() + " expecteur numero 1 : " + jury2.getFirstName() + " " + jury.getLastName();
        String subject = "Confirmation de la soutenance";

        try {
            sendMailsService.sendSimpleMessage(jury.getEmail(), subject, text);
            sendMailsService.sendSimpleMessage(jury.getEmail(), subject, text1);
            sendMailsService.sendSimpleMessage(student.getEmail(), subject, text2);
        } catch (MailException e) {
            throw new RuntimeException();

        }
    }
}
