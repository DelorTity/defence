package com.soutenances.soutenance.service;

import com.soutenances.soutenance.dto.UserDto;
import com.soutenances.soutenance.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findStudents();
    List<User> findTeacher();

    User saveTeacher(User user);

    User saveUser(User user);

    void deleteById(long id);

    User saveStudent(User user);

    User updateTeacher(UserDto updatedUser, long id);
    Optional<User> findById(long id);
}
