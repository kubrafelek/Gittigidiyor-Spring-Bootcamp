package dev.controller;

import dev.models.*;
import dev.service.StudentService;
import dev.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;


public class StudentController {


    private StudentService studentService = new StudentService();

    public Student findStudent(int studentId) {
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    public void saveStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(int id){
        studentService.deleteFromDatabase(id);
    }

    public List<Course> findCoursesOfStudents(int id) {
        return null;
    }


}
