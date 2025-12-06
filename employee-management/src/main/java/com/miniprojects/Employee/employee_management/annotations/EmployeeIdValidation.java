package com.miniprojects.Employee.employee_management.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = EmployeeIdValidator.class)
public @interface EmployeeIdValidation {

    String message() default "Employee Id should starts with FIN-";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
