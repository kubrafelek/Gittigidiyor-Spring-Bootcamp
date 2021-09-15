package com.kubrafelek.devpatika.repository;

import com.kubrafelek.devpatika.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);
    void deleteByName(String name);

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getGenderWithGrouping();
}
