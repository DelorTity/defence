package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.repository.SpecialityRepository;
import com.soutenances.soutenance.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;


    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }
}
