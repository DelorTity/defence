package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.Defense;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.DefenseService;
import com.soutenances.soutenance.service.NotificationService;
import com.soutenances.soutenance.service.SendMailsService;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DefenseController {
    @Autowired
    private DefenseService defenseService;

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getDefense")
    public String getDefense(Model model) {
        List<User> students = userService.findStudents();
        List<User> teachers = userService.findTeacher();
        List<Defense> defenses = defenseService.findAll();
        System.out.println(defenses.size());

        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        model.addAttribute("defense", new DefenseDto());
        model.addAttribute("defenses", defenses);
        return "soutenance";
    }

    @PostMapping("/saveDefense")
    public String save(@ModelAttribute("defense") DefenseDto defenseDto, RedirectAttributes redirectAttributes) {
        defenseService.save(defenseDto);

        try {
            notificationService.SentNotificationMail(defenseDto);
            return "redirect:/getDefense";

        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Désolé, veuille vous connectez a intenet pour l'envoie effective de vos mail");
            return "redirect:/getDefense";

        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model) {
        defenseService.deleteById(id);
        return "redirect:/getDefense";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("defense") DefenseDto defenseDto, @PathVariable("id") long id) {
        defenseService.update(defenseDto, id);
        return "redirect:/getDefense";
    }
}
