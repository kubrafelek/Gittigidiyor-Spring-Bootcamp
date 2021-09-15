package com.kubrafelek.homework04.controller;

import com.kubrafelek.homework04.dto.InstructorDTO;
import com.kubrafelek.homework04.model.Instructor;
import com.kubrafelek.homework04.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    /**
     * The method list all instructors
     **/
    @GetMapping("/list-instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity(instructorService.findAll(), HttpStatus.OK);
    }

    //valid anotasyonu eklenmedi

    /**
     * The method add the new instructor.
     *
     * @param instructorDTO The instructor object
     */
    @PostMapping("/add-instructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody InstructorDTO instructorDTO) {

        Optional<Instructor> resultOptional = instructorService.saveInstructor(instructorDTO);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * The method find exist instructor by using instructor id.
     *
     * @param id The instructor id
     */
    @GetMapping("/findInstructorById/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable long id) {
        return new ResponseEntity(instructorService.findInstructorById(id), HttpStatus.OK);
    }

    /**
     * The method updates exist instructor data by using id.
     *
     * @param instructorDTO The instructor object
     * @param id            The instructor id
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody InstructorDTO instructorDTO, @PathVariable int id) {
        return new ResponseEntity(instructorService.updateInstructor(instructorDTO, id), HttpStatus.ACCEPTED);
    }

    /**
     * The method deletes exist instructor by using id.
     *
     * @param id The instructor id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Instructor> deleteIntructorById(@PathVariable long id) {
        return new ResponseEntity(instructorService.deleteInstructorById(id), HttpStatus.ACCEPTED);
    }
}
