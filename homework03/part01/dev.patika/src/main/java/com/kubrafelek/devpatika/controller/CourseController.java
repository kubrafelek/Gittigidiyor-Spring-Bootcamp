package com.kubrafelek.devpatika.controller;

import com.kubrafelek.devpatika.entity.Course;
import com.kubrafelek.devpatika.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //List all courses
    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>> findAllCourse() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    //Get course by course id
    @GetMapping("/courseId/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    //Add new course to course list
    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id) {
        return new ResponseEntity<>(courseService.update(course, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable int id) {
        return new ResponseEntity(courseService.deleteById(id), HttpStatus.ACCEPTED);
    }

    //Can find course with a name
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Course>> findByCourseName(@PathVariable String name) {
        return new ResponseEntity(courseService.findByCourseName(name), HttpStatus.ACCEPTED);
    }

    //Can delete course by using course name
    @DeleteMapping("/deleteByName/{name}")
    public void deleteByCourseName(@PathVariable String name) {
        courseService.deleteByCourseName(name);
    }

}