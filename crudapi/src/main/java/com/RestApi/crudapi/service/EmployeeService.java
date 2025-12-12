package com.RestApi.crudapi.service;

import com.RestApi.crudapi.dto.EmployeeDto;
import com.RestApi.crudapi.entity.EmployeeEntity;
import com.RestApi.crudapi.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    final private EmployeeRepo employeeRepo;
    final private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper){
        this.employeeRepo=employeeRepo;
        this.modelMapper=modelMapper;
    }

    public Optional<EmployeeDto> getEmployeeById(Long id){
        Optional<EmployeeEntity> employeeEntity= Optional.ofNullable(employeeRepo.findById(id).orElse(null));

        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDto.class) );
//      return new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));

    }

    public List<EmployeeDto> getAllEmployee(){
        List<EmployeeEntity> employees= employeeRepo.findAll();
        System.out.println(employees);

        // Traditional method
//        List<employeeDto> dtoReturnVal= new ArrayList<>();
//        for(entity ent:employees){
//            //This is the one way to change the object type from entity to dto. Better if we use ModalMapper.
//            dtoReturnVal.add(new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));
//        }
//        return dtoReturnVal;
        return employees.stream()
                .map(employee-> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto){
        EmployeeEntity toSaveEntity=modelMapper.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity savedEntity=employeeRepo.save(toSaveEntity);

        return modelMapper.map(savedEntity,EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto){
        EmployeeEntity toUpdateEntity= modelMapper.map(employeeDto,EmployeeEntity.class);
        // id is present: it will update the data of that id.
        // id is not present: it will create a new id and will add the responsebody.
        toUpdateEntity.setId(id);
        EmployeeEntity savedEntity= employeeRepo.save(toUpdateEntity);
        return  modelMapper.map(savedEntity,EmployeeDto.class);
    }

        public EmployeeDto updatePatchValue(Long id, Map<String,Object> updates){
            EmployeeEntity employeeEntity=employeeRepo.findById(id).get();
            updates.forEach((field,value)-> {
                Field requiredField=ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
                requiredField.setAccessible(true);
                ReflectionUtils.setField(requiredField,employeeEntity,value);
            });
            return modelMapper.map(employeeRepo.save(employeeEntity),EmployeeDto.class);
        }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean returnVal=employeeRepo.existsById(employeeId);
        if(!returnVal)
            return false;
        employeeRepo.deleteById(employeeId);
        return true;
    }
}
