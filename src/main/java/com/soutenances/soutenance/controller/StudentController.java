package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.entities.Topic;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.SpecialityService;
import com.soutenances.soutenance.service.TopicService;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private SpecialityService specialityService;
    @GetMapping("/getStudents")
    public String getTeachers(Model model) {
        List<Speciality> specialities = specialityService.findAll();
        List<Topic> topicList = topicService.findAll();
        List<User> students = userService.findStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", new User());
        model.addAttribute("topic", topicList);
        model.addAttribute("speciality", specialities);
        return "getStudents";
    }

    @PostMapping("/saveStudent")
    public String saveTeacher(@ModelAttribute("student") User user) {
        userService.saveTeacher(user);
        return "redirect:/getStudent";
    }

}
