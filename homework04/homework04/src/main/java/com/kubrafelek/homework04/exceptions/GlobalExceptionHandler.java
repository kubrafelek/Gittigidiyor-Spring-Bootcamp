package com.kubrafelek.homework04.exceptions;

import com.kubrafelek.homework04.model.ExceptionsLogger;
import com.kubrafelek.homework04.model.enumeration.ExceptionType;
import com.kubrafelek.homework04.repository.ExceptionLoggerRepository;
import com.kubrafelek.homework04.util.ClientRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(StudentAgeNotValidException exc) {
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());

        this.saveExceptionToDatabase(HttpStatus.BAD_REQUEST, exc.getMessage(), ExceptionType.StudentAgeNotValidException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(StudentNumberForOneCourseExceededException exc) {
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());

        this.saveExceptionToDatabase(HttpStatus.BAD_REQUEST, exc.getMessage(), ExceptionType.StudentNumberForOneCourseExceededException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(CourseIsAlreadyExistException exc) {
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());

        this.saveExceptionToDatabase(HttpStatus.BAD_REQUEST, exc.getMessage(), ExceptionType.CourseIsAlreadyExistException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppErrorResponse> handleException(InstructorIsAlreadyExistException exc) {
        AppErrorResponse response = prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());

        this.saveExceptionToDatabase(HttpStatus.BAD_REQUEST, exc.getMessage(), ExceptionType.InstructorIsAlreadyExistException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private AppErrorResponse prepareErrorResponse(HttpStatus httpStatus, String message) {
        AppErrorResponse response = new AppErrorResponse();
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setTimestamp(System.currentTimeMillis());

        return response;
    }

    private void saveExceptionToDatabase(HttpStatus httpStatus, String message, ExceptionType exceptionType) {

        ExceptionsLogger exceptionsLogger = new ExceptionsLogger();

        exceptionsLogger.setMessage(message);
        exceptionsLogger.setStatus(httpStatus.value());
        exceptionsLogger.setExceptionType(exceptionType);
        exceptionsLogger.setExceptionDataTime(LocalDateTime.now());
        exceptionsLogger.setClientUrl(clientRequestInfo.getClientUrl());
        exceptionsLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        exceptionsLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());

        this.exceptionLoggerRepository.save(exceptionsLogger);
    }
}
