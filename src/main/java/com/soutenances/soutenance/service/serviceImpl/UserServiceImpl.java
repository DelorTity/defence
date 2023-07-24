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
import com.soutenances.soutenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<User> findStudents() {
        return userRepository.findByRulesId(1);
    }

    @Override
    public List<User> findTeacher() {
        return userRepository.findByRulesId(2);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveTeacher(User user) {
        Optional<Rule> optionalRule = ruleRepository.findById(2L);
        List<Rule> rules = new ArrayList<>();
        rules.add(optionalRule.get());

        user.setRules(rules);

        return userRepository.save(user);
    }

    @Override
    public User saveStudent(User user) {
        Optional<Rule> optionalRule = ruleRepository.findById(1L);
        List<Rule> rules = new ArrayList<>();
        rules.add(optionalRule.get());

        Topic topic = topicRepository.findById(user.getTopic().getId()).orElse(null);
        Speciality specialty = specialityRepository.findById(user.getSpeciality().getId()).orElse(null);

        user.setRules(rules);
        user.setTopic(topic);
        user.setSpeciality(specialty);

        return userRepository.save(user);
    }

    public User updateTeacher(UserDto updatedUser, long id) {
        User existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setZip(updatedUser.getZip());
        existingUser.setTel(updatedUser.getTel());
        existingUser.setCountry(updatedUser.getCountry());
        existingUser.setCity(updatedUser.getCity());

        Optional<Rule> optionalRule = ruleRepository.findById(2L);
        List<Rule> rules = new ArrayList<>();
        rules.add(optionalRule.get());

        existingUser.setRules(rules);

        return userRepository.save(existingUser);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
