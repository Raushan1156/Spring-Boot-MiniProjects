package com.miniprojects.Employee.employee_management.controller;

import com.miniprojects.Employee.employee_management.dto.EmployeeDto;
import com.miniprojects.Employee.employee_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee")
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new  ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
