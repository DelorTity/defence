package com.soutenances.soutenance.dto;

import com.soutenances.soutenance.entities.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int tel;
    private String country;
    private String city;
    private int zip;
    private Rule rules;

}
