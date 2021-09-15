package com.kubrafelek.homework04.repository;

import com.kubrafelek.homework04.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Course c WHERE c.courseCode = ?1")
    boolean selectExistsCourseCode(int courseCode);

    Course findCourseByCourseCode(int courseCode);

}
