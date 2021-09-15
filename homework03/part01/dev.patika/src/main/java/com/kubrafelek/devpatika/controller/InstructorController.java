package com.kubrafelek.devpatika.controller;

import com.kubrafelek.devpatika.entity.Instructor;
import com.kubrafelek.devpatika.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/allInstructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, int id) {
        return new ResponseEntity<>(instructorService.update(instructor, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/instructors/{id}")
    public void deleteInstructorById(@PathVariable int id) {
        instructorService.deleteById(id);
    }

    //Can find instructor with a name
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Instructor>> findByInstructorName(@PathVariable String name) {
        return new ResponseEntity(instructorService.findByName(name), HttpStatus.ACCEPTED);
    }

    //Can delete instructor by using instructor name
    @DeleteMapping("/deleteByName/{name}")
    public void deleteByInstructorName(@PathVariable String name) {
        instructorService.deleteByName(name);
    }

    //Three PermanentInstructor with a minimum salary
    @GetMapping("/minfixedsalary")
    public ResponseEntity<List<Instructor>> firstThreeMinFixedSalary() {
        return new ResponseEntity<>(instructorService.firstThreeInstructorOfMinFixedSalary(), HttpStatus.OK);
    }

    //Three PermanentInstructor with a maximum salary
    @GetMapping("/maxfixedsalary")
    public ResponseEntity<List<Instructor>> firstThreeMaxFixedSalary() {
        return new ResponseEntity<>(instructorService.firstThreeInstructorOfMaxFixedSalary(), HttpStatus.OK);
    }

    //Three VisitingResearcher with a minimum salary
    @GetMapping("/minhourlysalary")
    public ResponseEntity<List<Instructor>> firstThreeMinHourlySalary() {
        return new ResponseEntity<>(instructorService.firstThreeInstructorOfMinHourlySalary(), HttpStatus.OK);
    }

    //Three VisitingResearcher with a maximum salary
    @GetMapping("/maxhourlysalary")
    public ResponseEntity<List<Instructor>> firstThreeMaxHourlySalary() {
        return new ResponseEntity<>(instructorService.firstThreeInstructorOfMaxHourlySalary(), HttpStatus.OK);
    }


}