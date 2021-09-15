package com.kubrafelek.devpatika.service;

import com.kubrafelek.devpatika.entity.Instructor;
import com.kubrafelek.devpatika.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructorList::add);
        return instructorList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return (Instructor) instructorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor, int id) {
        Instructor findInstructor = findById(id);
        findInstructor.setName(instructor.getName());
        findInstructor.setAddress(instructor.getAddress());
        findInstructor.setPhoneNumber(instructor.getPhoneNumber());
        return instructorRepository.save(findInstructor);
    }

    @Override
    public String deleteById(int id) {
        instructorRepository.deleteById(id);
        return "Instructor id => " + id + " Deleted....";
    }

    @Transactional
    public List<Instructor> findByName(String courseName) {
        return instructorRepository.findByName(courseName);
    }

    @Transactional
    public void deleteByName(String name) {
        instructorRepository.deleteByName(name);
    }

    public List<Instructor> firstThreeInstructorOfMinFixedSalary() {
        return instructorRepository.findFirstThreeMinFixedSalary();

    }

    public List<Instructor> firstThreeInstructorOfMaxFixedSalary() {
        return instructorRepository.findFirstThreeMaxFixedSalary();

    }

    public List<Instructor> firstThreeInstructorOfMinHourlySalary() {
        return instructorRepository.findFirstThreeMinHourlySalary();

    }

    public List<Instructor> firstThreeInstructorOfMaxHourlySalary() {
        return instructorRepository.findFirstThreeMaxHourlySalary();

    }

}
