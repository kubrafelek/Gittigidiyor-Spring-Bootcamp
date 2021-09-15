package com.kubrafelek.homework04.repository;

import com.kubrafelek.homework04.model.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END FROM Instructor i WHERE i.phoneNumber = ?1")
    boolean selectExistsPhoneNumber(String phoneNumber);
}
