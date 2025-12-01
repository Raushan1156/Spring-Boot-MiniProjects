package com.miniprojects.Employee.employee_management.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String email;
    String designation;
//    LocalDate dateOfJoining;
    Integer salary;
    boolean isActive;
}
