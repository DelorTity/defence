package com.soutenances.soutenance.controller;

import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/getSpecialities")
    public String getSpeciality(Model model) {
        List<Speciality> specialities = specialityService.findAll();
        System.out.println(specialities.size());

        model.addAttribute("specialities", specialities);
        model.addAttribute("speciality", new Speciality());
        return "getSpecialities";
    }

    @PostMapping("/saveSpeciality")
    public String saveStudent(@ModelAttribute("speciality") Speciality speciality) {
        Speciality speciality1 = specialityService.save(speciality);
        return "redirect:/getSpecialities";
    }

}
