package com.soutenances.soutenance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int tel;
    private String country;
    private String city;
    private int zip;

    @ManyToMany
    @JoinTable(name = "user_rule",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_rule", referencedColumnName = "id"))
    private List<Rule> rules = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Speciality speciality;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Topic topic;
}

