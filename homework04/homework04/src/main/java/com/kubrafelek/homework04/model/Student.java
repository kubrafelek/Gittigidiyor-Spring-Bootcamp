package com.kubrafelek.homework04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student extends AbstractBaseEntity {

    private String name;
    private LocalDate birthdate;
    private String address;
    private String gender;

    @ManyToMany
    private List<Course> courseList = new ArrayList<>();

}
