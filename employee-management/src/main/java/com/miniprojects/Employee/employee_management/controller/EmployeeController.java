package com.miniprojects.Employee.employee_management.controller;

import com.miniprojects.Employee.employee_management.EmployeeManagementApplication;
import com.miniprojects.Employee.employee_management.dto.EmployeeDto;
import com.miniprojects.Employee.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
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

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new  ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployeeDetails(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        boolean isDeleted = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> patchEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.patchEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

}
