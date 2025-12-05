package com.miniprojects.Employee.employee_management.advices;

import com.miniprojects.Employee.employee_management.exception.DuplicateEmailException;
import com.miniprojects.Employee.employee_management.exception.EmployeeNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiError> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        ApiError apiError = ApiError.builder().
                httpStatus(HttpStatus.NOT_FOUND)
                .message(employeeNotFoundException.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(NoSuchElementException noSuchElementException){
        ApiError apiError = ApiError.builder().
                httpStatus(HttpStatus.NOT_FOUND)
                .message("Resource not found")
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        ApiError apiError = ApiError.builder().
                httpStatus(HttpStatus.BAD_REQUEST)
                .message("Invalid Json format")
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError apiError = ApiError.builder().
                httpStatus(HttpStatus.BAD_REQUEST)
                .message("Failing dto input validation ")
                .subErrors(errors)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiError> handleDuplicateEmail(DuplicateEmailException duplicateEmailException) {
        ApiError apiError = ApiError.builder().
                httpStatus(HttpStatus.CONFLICT)
                .message(duplicateEmailException.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }
}
