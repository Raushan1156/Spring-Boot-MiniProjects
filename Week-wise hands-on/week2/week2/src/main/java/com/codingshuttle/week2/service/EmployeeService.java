package com.codingshuttle.week2.service;

import com.codingshuttle.week2.dto.Employee;
import com.codingshuttle.week2.entity.EmployeeEntity;
import com.codingshuttle.week2.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepo empRepo;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo empRepo, ModelMapper modelMapper){
        this.empRepo=empRepo;
        this.modelMapper=modelMapper;
    }

//public EmployeeService(EmployeeRepo empRepo){
//    this.empRepo=empRepo;
//}

    public void getEmployeeById(Long id) {
//        boolean isExist=empRepo.existsById(id);
//        if (!isExist) return null;
        EmployeeEntity empEntity=empRepo.findById(id).orElse(null);
//        ModelMapper modelMapper1=new ModelMapper();
        //return modelMapper.map(empEntity,Optional<Employee> Employee.class);
    }

    public List<Employee> getAllEmployee() {
        List<EmployeeEntity> empEntity=empRepo.findAll();
        return empEntity
                .stream()
                .map(EmployeeEntity->modelMapper.map(EmployeeEntity,Employee.class))
                .collect(Collectors.toList());
    }

    public Employee addNewEmployee(Employee employee) {
        EmployeeEntity toSaveEntity=modelMapper.map(employee,EmployeeEntity.class);
        EmployeeEntity savedEntity = empRepo.save(toSaveEntity);
        return modelMapper.map(savedEntity,Employee.class);
    }

    public Employee updateEmployeeDto(Long employeeId, Employee employeeDto) {
    EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
    boolean isExist=empRepo.existsById(employeeId);
    if(!isExist) return null;
    employeeEntity.setId(employeeId);
    EmployeeEntity savedEntity = empRepo.save(employeeEntity);
    return modelMapper.map(savedEntity,Employee.class);
    }

    public boolean deleteEmployeeById(Long empId) {
        boolean existId=empRepo.existsById(empId);
        if(!existId) return false;
        empRepo.deleteById(empId);
        return true;
    }

    public Employee patchUpdateEmployee(Long id, Map<String, Object> updates) {
        boolean existId= empRepo.existsById(id);
        if(!existId) return null;
        EmployeeEntity employeeEntity=empRepo.findById(id).get();
        updates.forEach((field,value) -> {
            Field fieldUpdate= ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
//            Field fieldUpdate= ReflectionUtils.  .findField(EmployeeEntity.class,field);
            System.out.println(fieldUpdate);
            fieldUpdate.setAccessible(true);
            System.out.println(fieldUpdate);
            ReflectionUtils.setField(fieldUpdate,employeeEntity,value);
        });

       return modelMapper.map(empRepo.save(employeeEntity),Employee.class);
    }
}
