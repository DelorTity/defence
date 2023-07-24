package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.entities.Defense;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.DefenseService;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DefenseController {
    @Autowired
    private DefenseService defenseService;

    @Autowired
    private UserService userService;

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
    public String save(@ModelAttribute("defense") DefenseDto defenseDto) {
        defenseService.save(defenseDto);
        return "redirect:/getDefense";
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
