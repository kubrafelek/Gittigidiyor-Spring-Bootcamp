package com.kubrafelek.devpatika.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthdate;
    private String address;
    private String gender;

    @ManyToMany
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, LocalDate birthdate, String address, String gender) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
    }
}
