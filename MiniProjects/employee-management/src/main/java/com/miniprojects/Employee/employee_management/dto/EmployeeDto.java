package com.miniprojects.Employee.employee_management.dto;

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
    String name;
    String email;
    String designation;
//    LocalDate dateOfJoining;
    Integer salary;
    boolean isActive;
}
