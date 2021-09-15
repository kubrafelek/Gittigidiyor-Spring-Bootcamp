package com.kubrafelek.devpatika.controller;

import com.kubrafelek.devpatika.entity.Student;
import com.kubrafelek.devpatika.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Can list all students data
    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    //Can find student using by id
    @GetMapping("/studentId/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    //Can save student to database
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    //Can update student data
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, int id) {
        return new ResponseEntity<>(studentService.update(student, id), HttpStatus.ACCEPTED);
    }

    //Can delete student by using id
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    //Can find student with a name
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Student>> findByStudentName(@PathVariable String name) {
        return new ResponseEntity(studentService.findByName(name), HttpStatus.ACCEPTED);
    }

    //Can delete student by using student name
    @DeleteMapping("/deleteByName/{name}")
    public void deleteByStudentName(@PathVariable String name) {
        studentService.deleteByName(name);
    }

    //Students group with a gender
    @GetMapping("/getGenderWithGrouping")
    public List<?> getGenderWithGrouping() {
        return studentService.getGenderWithGrouping();
    }

}