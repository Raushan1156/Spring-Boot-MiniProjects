package com.codingshuttle.week2.controller;

import com.codingshuttle.week2.dto.Employee;
import com.codingshuttle.week2.entity.EmployeeEntity;
import com.codingshuttle.week2.repository.EmployeeRepo;
import com.codingshuttle.week2.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping (path="/employee")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

//    @GetMapping (path="{id}")
//    public EmployeeEntity employeeById(@PathVariable Long id){
//
//        return eRepo.findById(id).orElse(null);
//    }


//    @GetMapping (path="id")
//    public String employeeByIdWithDiffVar(@PathVariable (name="id") Long empId){
//        return "employeeByIdWithDiffVar:- "+empId;
//    }

//    @GetMapping
//    public List<EmployeeEntity> employeeByName(){
//        return eRepo.findAll();
//    }

//    @GetMapping
//    public String employeeByNameMeth2(@RequestParam (required=true, name = "naam") String name
//    ,@RequestParam (required=false) String sortBy){
//        return "This is method 2. name="+name+" "+sortBy;
//    }

//    @PostMapping
//    public EmployeeEntity addNewEmployee(@RequestBody EmployeeEntity eEntity){
//        return eRepo.save(eEntity);
//    }

// ------------------------------------------------------------------------------------------------------

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

//        Optional<Employee> emp1= empService.getEmployeeById(id);
//        return ResponseEntity;
        return null;
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return empService.getAllEmployee();
    }

    @PostMapping
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        Employee emp1=empService.addNewEmployee(employee);
        return new ResponseEntity<>(emp1, HttpStatus.CREATED);
    }


    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<Employee> updateEmpDto(@RequestBody Employee employeeDto, @PathVariable Long employeeId) {
        Employee emp1= empService.updateEmployeeDto(employeeId, employeeDto);

        if (emp1==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(emp1);
    }

    @DeleteMapping (path="/{empId}")
    public  ResponseEntity<Employee> deleteEmployee(@PathVariable Long empId){
//        try {
//            System.out.print("200 OK\nData deleted.");
//           return empService.deleteEmployeeById(empId);
//        }
//        catch (Exception e)
//        {
//            System.out.print("No data present with this ID:"+empId);
//            return false
//        }
        boolean isDeleted= empService.deleteEmployeeById(empId);
        // we can use ResponseEntity.ok instead of no conent if we want to return the content as well
        if (isDeleted) return ResponseEntity.noContent().build(); //204 is repsonse code
        return ResponseEntity.notFound().build();
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Employee> patchEmployee(@RequestBody Map<String, Object> updates, @PathVariable Long id){
        Employee emp1=empService.patchUpdateEmployee(id,updates);
        if(emp1==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(emp1);
//        return emp1;
    }
}
