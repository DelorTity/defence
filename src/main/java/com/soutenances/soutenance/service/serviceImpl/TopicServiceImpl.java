package com.soutenances.soutenance.service.serviceImpl;

import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.Rule;
import com.soutenances.soutenance.entities.Speciality;
import com.soutenances.soutenance.entities.Topic;
import com.soutenances.soutenance.entities.User;
import com.soutenances.soutenance.repository.RuleRepository;
import com.soutenances.soutenance.repository.SpecialityRepository;
import com.soutenances.soutenance.repository.TopicRepository;
import com.soutenances.soutenance.repository.UserRepository;
import com.soutenances.soutenance.service.TopicService;
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository topicRepository;


    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
