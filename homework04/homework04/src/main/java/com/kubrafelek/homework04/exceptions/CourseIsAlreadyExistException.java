package com.kubrafelek.homework04.exceptions;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String message) {
        super(message);
    }
}
