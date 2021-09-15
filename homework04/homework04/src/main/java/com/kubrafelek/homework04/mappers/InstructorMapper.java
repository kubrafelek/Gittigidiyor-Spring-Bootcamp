package com.kubrafelek.homework04.mappers;

import com.kubrafelek.homework04.dto.InstructorDTO;
import com.kubrafelek.homework04.model.Instructor;
import org.mapstruct.Mapper;

@Mapper
public interface InstructorMapper {

    Instructor mapFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);

    InstructorDTO mapFromInstructortoInstructorDTO(Instructor instructor);

}
