package com.soutenances.soutenance.service;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.entities.Defense;

import java.util.List;
import java.util.Optional;

public interface DefenseService {
    void save(com.soutenances.soutenance.dto.DefenseDto defenseDto);
    List<Defense> findAll();

    void deleteById(long id);

    Optional<Defense> findById(long id);

    Defense update(DefenseDto defenseDto, long id);
}
