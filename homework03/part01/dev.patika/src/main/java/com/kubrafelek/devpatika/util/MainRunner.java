package com.kubrafelek.devpatika.util;

import com.kubrafelek.devpatika.entity.*;
import com.kubrafelek.devpatika.repository.CourseRepository;
import com.kubrafelek.devpatika.repository.InstructorRepository;
import com.kubrafelek.devpatika.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
@RequiredArgsConstructor
public class MainRunner implements CommandLineRunner {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        instructorRepository.deleteAll();
        courseRepository.deleteAll();
        studentRepository.deleteAll();

        Student student1 = new Student("Merve Anık", LocalDate.of(1997, Month.JANUARY, 15), "Şile", "Female");
        Student student2 = new Student("Cem Gürsel", LocalDate.of(1997, Month.FEBRUARY, 11), "Şile", "Male");
        Student student3 = new Student("Anıl Güzel", LocalDate.of(1997, Month.SEPTEMBER, 5), "Şile", "Male");

        student1 = studentRepository.save(student1);
        student2 = studentRepository.save(student2);
        student3 = studentRepository.save(student3);

        Course course1 = new Course("Introduction To Java", 111, 4);
        Course course2 = new Course("Object Oriented Programming", 112, 3);
        Course course3 = new Course("Data Structures", 202, 4);

        course1 = courseRepository.save(course1);
        course2 = courseRepository.save(course2);
        course3 = courseRepository.save(course3);

        Instructor instructor1 = new VisitingResearcher("Emine Ekin", "İstanbul", "0532331256", 250.0);
        Instructor instructor2 = new PermanentInstructor("İlknur Karadeniz", "İstanbul", "0532331256", 14000.0);
        Instructor instructor3 = new PermanentInstructor("Boray Tek", "İstanbul", "0532331256", 16500.0);

        instructor1 = instructorRepository.save(instructor1);
        instructor2 = instructorRepository.save(instructor2);
        instructor3 = instructorRepository.save(instructor3);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);

    }
}
