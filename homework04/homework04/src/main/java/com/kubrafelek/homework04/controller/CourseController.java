package com.kubrafelek.homework04.controller;

import com.kubrafelek.homework04.dto.CourseDTO;
import com.kubrafelek.homework04.model.*;
import com.kubrafelek.homework04.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /**
     * The method list all courses
     **/
    @GetMapping("/list-courses")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity(courseService.findAll(), HttpStatus.OK);
    }

    /**
     * The method add student to course by using chosen course code.
     *
     * @param courseCode The course code
     * @param studentId  The Student's id.
     */
    @PutMapping("/save-student-to-course/{studentId}/{courseCode}")
    public ResponseEntity<Course> saveStudentToCourse(@PathVariable long studentId, @PathVariable int courseCode) {

        Optional<Course> resultOptional = courseService.saveStudentToCourse(studentId, courseCode);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * The method save instructor to course by using chosen course code.
     *
     * @param courseCode   The course code
     * @param instructorId The Instructor id.
     */
    @PutMapping("save-instructor-to-course/{instructorId}/{courseCode}")
    public ResponseEntity<Course> saveInstructorToCourse(@PathVariable long instructorId, @PathVariable int courseCode) {

        Optional<Course> resultOptional = courseService.saveInstructorToCourse(instructorId, courseCode);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * The method find exist course by using course code.
     *
     * @param courseCode The course code
     */
    @GetMapping("/findByCourseCode/{courseCode}")
    public ResponseEntity<Course> findCourseByCourseCode(@PathVariable int courseCode) {
        return new ResponseEntity(courseService.findCourseByCourseCode(courseCode), HttpStatus.ACCEPTED);
    }

    /**
     * The method find exist course by using course id.
     *
     * @param id The course id
     */
    @GetMapping("/findCourseById/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findCourseById(id), HttpStatus.OK);
    }

    //FIX: valid anotasyonu eklenmedi

    /**
     * The method add the new course.
     *
     * @param courseDTO The course object
     */
    @PostMapping("/add-course")
    public ResponseEntity addCourse(@RequestBody CourseDTO courseDTO) {

        Optional<Course> resultOptional = courseService.saveCourse(courseDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * The method updates exist course by using id.
     *
     * @param course The course object
     * @param id     The course id
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id) {
        return new ResponseEntity<>(courseService.update(course, id), HttpStatus.ACCEPTED);
    }

    /**
     * The method deletes exist course by using id.
     *
     * @param id The course id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable long id) {
        return new ResponseEntity(courseService.deleteById(id), HttpStatus.ACCEPTED);
    }

}
