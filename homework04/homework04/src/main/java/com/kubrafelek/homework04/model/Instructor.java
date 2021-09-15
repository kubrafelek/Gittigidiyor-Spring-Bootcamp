package com.kubrafelek.homework04.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor extends AbstractBaseEntity{

    private String name;
    private String address;
    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();

}
