package com.kubrafelek.devpatika.service;

import com.kubrafelek.devpatika.entity.Course;
import com.kubrafelek.devpatika.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course update(Course course, int id) {
        Course findCourse = findById(id);
        findCourse.setCourseName(course.getCourseName());
        findCourse.setCourseCode(course.getCourseCode());
        findCourse.setCreditScore(course.getCreditScore());
        return courseRepository.save(findCourse);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        courseRepository.deleteById(id);
        return "Course id => " + id + " Deleted....";
    }

    @Transactional
    public List<Course> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Transactional
    public void deleteByCourseName(String name) {
        courseRepository.deleteByCourseName(name);
    }


}
