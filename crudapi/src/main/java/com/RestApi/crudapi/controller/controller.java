package com.RestApi.crudapi.controller;

import com.RestApi.crudapi.dto.EmployeeDto;
import com.RestApi.crudapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class controller {

    private final EmployeeService employeeService;
    public controller(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    ArrayList<String> employee=new ArrayList<>(Arrays.asList("Raushan","Ramesh", "Rohan"));

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
//        List<entity> returnValue= employeeService.findAll();
//        System.out.println(returnValue);
//        List<employeeDto> dtoReturnVal= new ArrayList<>();
//        for(entity ent:returnValue){
//            dtoReturnVal.add(new employeeDto(ent.getId(),ent.getName(),ent.getEmail(),ent.getAge(),ent.getDateOfJoining(),ent.getIsActive()));
//        }
        List<EmployeeDto> getAllEmployeeDetails = employeeService.getAllEmployee();
        if (getAllEmployeeDetails==null)
            return  ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(getAllEmployeeDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
//        if (id <= employee.size()-1)
//            return employee.get(id.intValue()-1);
//        else
//            return "Your " + id + " doesn't exist";
        Optional<EmployeeDto> employeeDtoOptional= employeeService.getEmployeeById(id);
        return employeeDtoOptional
                .map(employeeDtoOptional1-> ResponseEntity.ok(employeeDtoOptional1))
                //.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with the given ID was not found."));
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
//        employee.add(name);
//    return " added name: "+name;
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createNewEmployee(employeeDto));
    }

    @PutMapping("/{employeeID}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable (name = "employeeID") Long id, @RequestBody EmployeeDto employeeDto){
//        employee.set(id.intValue()-1,name);
//        return employee;

        return ResponseEntity.ok(employeeService.updateEmployeeById(id,employeeDto));
    }

    @PatchMapping("/{empId}")
    public ResponseEntity<EmployeeDto> updatePatchValue(@PathVariable (name="empId") Long id, @RequestBody Map<String,Object> employeeDto){
        EmployeeDto patchedData=employeeService.updatePatchValue(id,employeeDto);
        if (patchedData!=null)
            return ResponseEntity.ok(patchedData);
        else
            return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
//        if (!employee.isEmpty()){
//            employee.removeLast();
//        return employee;
//        }
//        else{
//            employee.add("employe is empty");
//            return employee;
//        }
        boolean deletedEmployee= employeeService.deleteEmployeeById(employeeId);
        if (deletedEmployee)
            return ResponseEntity.ok(deletedEmployee);
        else
            return ResponseEntity.notFound().build();
    }

}

@RestController
class ErrorHandler {
    @GetMapping("/")
    public String errorHandler() {
        return "Please enter the correct api.";
    }


}
