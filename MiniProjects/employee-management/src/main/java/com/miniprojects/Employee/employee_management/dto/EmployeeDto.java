package com.miniprojects.Employee.employee_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    String name;
    @Email(message = "Email should be in format.")
    String email;
    @NotBlank(message = "Designation should not be empty")
    @Size(min=3, message = "Designation should have at least 3 letter")
    String designation;
//    LocalDate dateOfJoining;

    @Min(value = 5000, message = "Salary should be at least 5000.")
    Integer salary;
//    @JsonProperty("active")
    Boolean active;
}
