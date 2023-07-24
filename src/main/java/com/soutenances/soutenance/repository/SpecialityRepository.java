package com.soutenances.soutenance.repository;

import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
