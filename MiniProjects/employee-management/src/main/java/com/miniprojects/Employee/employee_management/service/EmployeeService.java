package com.miniprojects.Employee.employee_management.service;

//import com.miniprojects.Employee.employee_management.config.ModelMapperConfig;
import com.miniprojects.Employee.employee_management.dto.EmployeeDto;
import com.miniprojects.Employee.employee_management.entity.EmployeeEntity;
import com.miniprojects.Employee.employee_management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity dataToBeSaved = modelMapper.map(employeeDto, EmployeeEntity.class);
        EmployeeEntity savedData = employeeRepository.save(dataToBeSaved);
        return modelMapper.map(savedData, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployee() {
//        EmployeeEntity employeeEntity = new EmployeeEntity(1L,"Raushan","raushan@gmail.com","Manager", 50000,true);
        List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        return employeeEntity.stream()
                .map(entity -> modelMapper.map(employeeEntity, EmployeeDto.class)).toList();
    }

    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//        EmployeeEntity employeeEntity = new EmployeeEntity(id,"Raushan","raushan@gmail.com","Manager", 50000,true);
        return  modelMapper.map(employeeEntity, EmployeeDto.class);
    }
}
