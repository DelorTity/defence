package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.repository.UserRepository;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TeacherController {
    @Autowired
    private UserService userService;

    @GetMapping("/getTeachers")
    public String getTeachers(Model model) {
        List<User> teachers = userService.findTeacher();
        model.addAttribute("teachers", teachers);
        model.addAttribute("teacher", new User());
        return "getTeachers";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") User user) {
       userService.saveTeacher(user);
        return "redirect:/getTeachers";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") long id, Model model) {
        userService.deleteById(id);
        return "redirect:/getTeachers";
    }

    @PostMapping("/updateTeacher/{id}")
    public String updateTeacher(@ModelAttribute("teacher") UserDto userDto, @PathVariable("id") long id) {
        userService.updateTeacher(userDto, id);
        return "redirect:/getTeachers";
    }
}
