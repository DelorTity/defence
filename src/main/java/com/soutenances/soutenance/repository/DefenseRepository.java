package com.soutenances.soutenance.repository;

import com.soutenances.soutenance.entities.Defense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends JpaRepository<Defense, Long> {
}
