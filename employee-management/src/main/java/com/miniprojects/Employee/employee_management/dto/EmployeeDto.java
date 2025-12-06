package com.miniprojects.Employee.employee_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miniprojects.Employee.employee_management.annotations.EmployeeIdValidation;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    @Size(min=3, message = "Name should not be empty.")
    @NotBlank(message = "Name is empty.")
    String name;

    @NotBlank(message = "Email can't be empty.")
    @Email(message = "Email should be in format.")
    String email;

    @Size(min = 4, message = "Employee id should have at least 5 chars")
    @NotBlank(message = "Employee id should be empty.")
    @EmployeeIdValidation(message = "Employee id should be in formate of FIN-1")
    String employeeId;

    @NotBlank(message = "Designation should not be empty")
    @Size(min=3, message = "Designation should have at least 3 letter")
    String designation;
//    LocalDate dateOfJoining;

    @Positive
    @Min(value = 5000, message = "Salary should be at least 5000.")
    Integer salary;
//    @JsonProperty("active")
    Boolean active;
}
