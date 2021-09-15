package com.kubrafelek.homework04.util;

import com.kubrafelek.homework04.exceptions.BadRequestException;

public class StudentValidatorUtil {

    public static void validateStudentAge(int studentAge) {
        System.out.println(studentAge);
        if(studentAge < 18 || studentAge > 40){
            throw new BadRequestException(ErrorMessageConstants.STUDENT_AGE);
        }
    }
}
