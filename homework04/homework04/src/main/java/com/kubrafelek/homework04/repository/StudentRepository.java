package com.kubrafelek.homework04.repository;

import com.kubrafelek.homework04.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
