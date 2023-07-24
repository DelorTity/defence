package com.soutenances.soutenance.service;

import com.soutenances.soutenance.dto.DefenseDto;
import com.soutenances.soutenance.entities.Defense;
import com.soutenances.soutenance.entities.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    List<Topic> findAll();
}
