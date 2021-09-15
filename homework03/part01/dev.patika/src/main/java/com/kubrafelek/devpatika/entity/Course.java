package com.kubrafelek.devpatika.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data //ReqArgsConst. + Getter + Setter + EqualsHash + ToString
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int courseCode;
    private int creditScore;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

    public Course(String courseName, int courseCode, int creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }
}
