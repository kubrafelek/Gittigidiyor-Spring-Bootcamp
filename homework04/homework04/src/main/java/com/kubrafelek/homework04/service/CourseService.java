package com.kubrafelek.homework04.service;

import com.kubrafelek.homework04.dto.CourseDTO;
import com.kubrafelek.homework04.exceptions.CourseIsAlreadyExistException;
import com.kubrafelek.homework04.exceptions.StudentNumberForOneCourseExceededException;
import com.kubrafelek.homework04.mappers.CourseMapper;
import com.kubrafelek.homework04.model.Course;
import com.kubrafelek.homework04.model.Instructor;
import com.kubrafelek.homework04.model.Student;
import com.kubrafelek.homework04.model.TransactionLogger;
import com.kubrafelek.homework04.model.enumeration.TransactionType;
import com.kubrafelek.homework04.repository.CourseRepository;
import com.kubrafelek.homework04.repository.InstructorRepository;
import com.kubrafelek.homework04.repository.StudentRepository;
import com.kubrafelek.homework04.repository.TransactionLoggerRepository;
import com.kubrafelek.homework04.util.ClientRequestInfo;
import com.kubrafelek.homework04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    private final CourseMapper courseMapper;
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;

    //Add course function
    @Transactional
    public Optional<Course> saveCourse(CourseDTO courseDTO) {

        boolean isExists = courseRepository.selectExistsCourseCode(courseDTO.getCourseCode());
        if (isExists) {
            throw new CourseIsAlreadyExistException("Course " + courseDTO.getCourseName() + " code " + courseDTO.getCourseCode() + " is already exists !");
        }

        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return Optional.of(courseRepository.save(course));
    }

    //Add student to chosen course
    @Transactional
    public Optional<Course> saveStudentToCourse(long studentId, int courseCode) {

        Student student = findStudentById(studentId);
        Course course = findCourseByCourseCode(courseCode);
        course.getStudentList().add(student);

        if (course.getStudentList().size() > 20) {
            throw new StudentNumberForOneCourseExceededException(ErrorMessageConstants.STUDENT_COUNT);
        }

        //Transactions method
        this.saveTransactionToDatabase(course, courseCode, student, TransactionType.ADD_STUDENT);

        return Optional.of(courseRepository.save(course));
    }

    //Add instructır to exist course
    @Transactional
    public Optional<Course> saveInstructorToCourse(long instructorId, int courseCode) {

        Instructor instructor = findInstructorById(instructorId);
        Course course = findCourseByCourseCode(courseCode);
        course.setInstructor(instructor);

        return Optional.of(courseRepository.save(course));
    }

    private void saveTransactionToDatabase(Course course, int courseCode, Student student, TransactionType transactionType) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setCourseCode(courseCode);
        transactionLogger.setStudentId(student.getId());
        transactionLogger.setTransactionDataTime(LocalDateTime.now());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setTransactionType(transactionType);

        this.transactionLoggerRepository.save(transactionLogger);
    }

    //Find Course by course code
    @Transactional
    public Course findCourseByCourseCode(int courseCode) {
        return courseRepository.findCourseByCourseCode(courseCode);
    }

    //Find student wit id
    @Transactional
    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    //Find instructor wit id
    @Transactional
    public Instructor findInstructorById(long id) {
        return instructorRepository.findById(id).get();
    }

    //List all recorded courses
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    //Find Course with id
    @Transactional
    public Course findCourseById(long id) {
        return courseRepository.findById(id).get();
    }

    //Update Course
    @Transactional
    public Course update(Course course, long id) {
        Course findCourse = findCourseById(id);
        findCourse.setCourseName(course.getCourseName());
        findCourse.setCourseCode(course.getCourseCode());
        findCourse.setCreditScore(course.getCreditScore());
        return courseRepository.save(findCourse);
    }

    //Delete course
    @Transactional
    public String deleteById(long id) {
        courseRepository.deleteById(id);
        return "Course id => " + id + " Deleted....";
    }
}
