package com.miniprojects.Employee.employee_management.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeIdValidator implements ConstraintValidator<EmployeeIdValidation, String> {

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext context) {
        return inputValue.startsWith("FIN-");
    }
}
