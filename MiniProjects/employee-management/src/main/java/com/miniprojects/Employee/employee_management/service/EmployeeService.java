package com.miniprojects.Employee.employee_management.service;

//import com.miniprojects.Employee.employee_management.config.ModelMapperConfig;
import com.miniprojects.Employee.employee_management.dto.EmployeeDto;
import com.miniprojects.Employee.employee_management.entity.EmployeeEntity;
import com.miniprojects.Employee.employee_management.exception.DuplicateEmailException;
import com.miniprojects.Employee.employee_management.exception.EmployeeNotFoundException;
import com.miniprojects.Employee.employee_management.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        isEmailDuplocate(employeeDto.getEmail());
        EmployeeEntity dataToBeSaved = modelMapper.map(employeeDto, EmployeeEntity.class);
        EmployeeEntity savedData = employeeRepository.save(dataToBeSaved);
        return modelMapper.map(savedData, EmployeeDto.class);
    }

    private void isEmailDuplocate(String email) {
//        EmployeeEntity isEmailDuplocate = employeeRepository.findByEmail(email);
        boolean exists = employeeRepository.findByEmail(email).isPresent();

        if(exists) {
            throw new DuplicateEmailException(email + " is duplicate");
        }
    }

    public List<EmployeeDto> getAllEmployee() {
//        EmployeeEntity employeeEntity = new EmployeeEntity(1L,"Raushan","raushan@gmail.com","Manager", 50000,true);
        List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        return employeeEntity.stream()
                .map(entity -> modelMapper.map(entity, EmployeeDto.class)).toList();
    }

    public EmployeeDto getEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:"+id));
//        EmployeeEntity employeeEntity = new EmployeeEntity(id,"Raushan","raushan@gmail.com","Manager", 50000,true);
        return  modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeDetails(Long id, EmployeeDto employeeDto) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        modelMapper.map(employeeDto, existingEmployee); // copied data to entity object
        EmployeeEntity savedData = employeeRepository.save(existingEmployee);
        return modelMapper.map(savedData, EmployeeDto.class);
    }

    public boolean deleteEmployee(Long id) {
        boolean deletedEmployee = employeeRepository.existsById(id);
        if(deletedEmployee){
            employeeRepository.deleteById(id);
        }
        return deletedEmployee;
    }

    public EmployeeDto patchEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeEntity dateToBeSaved = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        if(employeeDto.getName() != null){
            dateToBeSaved.setName(employeeDto.getName());
        }
        if(employeeDto.getDesignation() != null){
            dateToBeSaved.setDesignation(employeeDto.getDesignation());
        }
        if(employeeDto.getEmail() != null){
            dateToBeSaved.setEmail(employeeDto.getEmail());
        }
        if(employeeDto.getSalary() != null){
            dateToBeSaved.setSalary(employeeDto.getSalary());
        }
        if(employeeDto.getActive() != null){
            dateToBeSaved.setActive(employeeDto.getActive());
        }
        EmployeeEntity savedData = employeeRepository.save(dateToBeSaved);
        return modelMapper.map(savedData, EmployeeDto.class);
    }
}
