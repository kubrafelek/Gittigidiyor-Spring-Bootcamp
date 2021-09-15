package com.kubrafelek.devpatika.service;

import com.kubrafelek.devpatika.entity.Course;
import com.kubrafelek.devpatika.entity.Student;
import com.kubrafelek.devpatika.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    //injection gerçekleştirilir
    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    //performans acısından yararlı
    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student, int id) {
        Student findStudent = findById(id);
        findStudent.setName(student.getName());
        findStudent.setGender(student.getGender());
        findStudent.setBirthdate(student.getBirthdate());
        return studentRepository.save(findStudent);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        studentRepository.deleteById(id);
        return "Student id => " + id + " Deleted....";
    }

    @Transactional
    public List<Student> findByName(String courseName) {
        return studentRepository.findByName(courseName);
    }

    @Transactional
    public void deleteByName(String name) {
        studentRepository.deleteByName(name);
    }

    public List<?> getGenderWithGrouping() {
        return studentRepository.getGenderWithGrouping();
    }

}
