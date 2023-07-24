package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.entities.Defense;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.repository.DefenseRepository;
import com.soutenances.soutenance.repository.UserRepository;
import com.soutenances.soutenance.service.DefenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DefenseServiceImpl implements DefenseService {
    private final DefenseRepository defenseRepository;
    private final UserRepository userRepository;

    public DefenseServiceImpl(DefenseRepository defenseRepository, UserRepository userRepository) {
        this.defenseRepository = defenseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(DefenseDto defenseDto) {
        User student = userRepository.findById(defenseDto.getStudent()).get();
        User jury1 = userRepository.findById(defenseDto.getJury1()).get();
        User jury2 = userRepository.findById(defenseDto.getJury2()).get();
        User jury3 = userRepository.findById(defenseDto.getJury3()).get();
        User supervisor = userRepository.findById(defenseDto.getSupervisor()).get();
        Defense defense = new Defense();

        defense.setClassroom(defenseDto.getClassroom());
        defense.setDate(defenseDto.getDate());
        defense.setStudent(student);
        defense.setJury1(jury1);
        defense.setJury2(jury2);
        defense.setJury3(jury3);
        defense.setSupervisor(supervisor);
        defense.setTime(defenseDto.getTime());

        defenseRepository.save(defense);
    }

    @Override
    public List<Defense> findAll() {
        return defenseRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        defenseRepository.deleteById(id);
    }

    public Optional<Defense> findById(long id) {
        return defenseRepository.findById(id);
    }

    public Defense update(DefenseDto defenseDto, long id) {
        Defense defense = defenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Defense not found"));

        User student = userRepository.findById(defenseDto.getStudent()).get();
        User jury1 = userRepository.findById(defenseDto.getJury1()).get();
        User jury2 = userRepository.findById(defenseDto.getJury2()).get();
        User jury3 = userRepository.findById(defenseDto.getJury3()).get();
        User supervisor = userRepository.findById(defenseDto.getSupervisor()).get();

        defense.setJury2(jury2);
        defense.setJury1(jury1);
        defense.setJury3(jury3);
        defense.setStudent(student);
        defense.setSupervisor(supervisor);
        defense.setClassroom(defenseDto.getClassroom());
        defense.setDate(defenseDto.getDate());
        defense.setTime(defenseDto.getTime());

        return  defenseRepository.save(defense);
    }

}
