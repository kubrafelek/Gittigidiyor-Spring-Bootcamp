package com.kubrafelek.homework04.controller;

import com.kubrafelek.homework04.dto.StudentDTO;
import com.kubrafelek.homework04.model.Student;
import com.kubrafelek.homework04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    /**
     * The method list all students
     **/
    @GetMapping("/list-students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity(studentService.findAll(), HttpStatus.OK);
    }

    /**
     * The method add the new student.
     *
     * @param studentDTO The student object
     */
    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudentToCourse(@RequestBody StudentDTO studentDTO) {

        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * The method deletes exist student by using id.
     *
     * @param id The student id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable long id) {
        return new ResponseEntity(studentService.deleteStudentById(id), HttpStatus.ACCEPTED);
    }
}
