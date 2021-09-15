package com.kubrafelek.devpatika.repository;

import com.kubrafelek.devpatika.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    List<Instructor> findByName(String name);
    void deleteByName(String name);

    // Custom queries
    @Query(nativeQuery = true, value = "select TOP 3 * from instructor order by fixed_salary")
    List<Instructor> findFirstThreeMinFixedSalary();

    @Query(nativeQuery = true, value = "select TOP 3 * from instructor order by fixed_salary desc")
    List<Instructor> findFirstThreeMaxFixedSalary();

    @Query(nativeQuery = true, value = "select TOP 3 * from instructor order by hourly_salary")
    List<Instructor> findFirstThreeMinHourlySalary();

    @Query(nativeQuery = true, value = "select TOP 3 * from instructor order by hourly_salary desc")
    List<Instructor> findFirstThreeMaxHourlySalary();
}
