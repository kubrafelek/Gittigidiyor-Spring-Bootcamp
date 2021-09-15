package com.kubrafelek.homework04.mappers;

import com.kubrafelek.homework04.dto.StudentDTO;
import com.kubrafelek.homework04.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    public abstract Student mapFromStudenttoStudentDTO(Student student);
}
