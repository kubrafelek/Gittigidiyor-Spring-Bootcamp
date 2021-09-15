package com.kubrafelek.homework04.service;

import com.kubrafelek.homework04.dto.StudentDTO;
import com.kubrafelek.homework04.exceptions.StudentAgeNotValidException;
import com.kubrafelek.homework04.mappers.StudentMapper;
import com.kubrafelek.homework04.model.Student;
import com.kubrafelek.homework04.repository.CourseRepository;
import com.kubrafelek.homework04.repository.StudentRepository;
import com.kubrafelek.homework04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    public Optional<Student> saveStudent(StudentDTO studentDTO) {
        //Checked the student age is valid for this function
        Period studentPeriod = Period.between(studentDTO.getBirthdate(), LocalDate.now());
        if (studentPeriod.getYears() < 18 || studentPeriod.getYears() > 40) {
            throw new StudentAgeNotValidException(ErrorMessageConstants.STUDENT_AGE);
        }

        Student student = studentMapper.mapFromStudentDTOtoStudent(studentDTO);
        return Optional.of(studentRepository.save(student));
    }

    @Transactional
    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public String deleteStudentById(long id) {
        studentRepository.deleteById(id);
        return "Student id " + id + " deleted.";
    }
}
