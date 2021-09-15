package com.kubrafelek.devpatika.repository;

import com.kubrafelek.devpatika.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findByCourseName(String name);
    void deleteByCourseName(String name);
}
