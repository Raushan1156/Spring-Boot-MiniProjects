package com.miniprojects.Employee.employee_management.service;

import com.miniprojects.Employee.employee_management.dto.EmployeeDto;
import com.miniprojects.Employee.employee_management.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {

    ModelMapper modelMapper = new ModelMapper();
    public EmployeeDto getAllEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1L,"Raushan","raushan@gmail.com","Manager", 50000,true);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = new EmployeeEntity(id,"Raushan","raushan@gmail.com","Manager", 50000,true);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }
}
