package com.miniprojects.Employee.employee_management.exception;

public class DuplicateEmployeeIdException extends RuntimeException{
    public DuplicateEmployeeIdException(String message){
        super(message);
    }
}
