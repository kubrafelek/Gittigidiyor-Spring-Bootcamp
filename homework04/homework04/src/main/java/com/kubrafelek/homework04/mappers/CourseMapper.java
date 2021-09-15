package com.kubrafelek.homework04.mappers;

import com.kubrafelek.homework04.dto.CourseDTO;
import com.kubrafelek.homework04.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {

    public abstract Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);

}
