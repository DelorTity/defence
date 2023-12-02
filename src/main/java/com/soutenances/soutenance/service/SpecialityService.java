package com.soutenances.soutenance.service;

import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.entities.Topic;

import java.util.List;

public interface SpecialityService {

    List<Speciality> findAll();

    Speciality save(Speciality speciality);
}
