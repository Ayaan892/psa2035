package com.crm.controller;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/v1/employee/add
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
            @Valid   @RequestBody EmployeeDto dto,
            BindingResult result       // job of this annotation is to copy jason content to java object

    ) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        EmployeeDto employeeDto = employeeService.addEmployee(dto);

        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);


    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
            @RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>( "deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> UpdateEmployee(
            @RequestParam Long id,
           @RequestBody EmployeeDto dto
    ) {
        employeeService.updateEmployee(id, dto);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(

    ) {
        List<EmployeeDto> employeesDto = employeeService.getEmployee();
        return new ResponseEntity<>(employeesDto,HttpStatus.OK);

    }

    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable Long empId
    ){
        EmployeeDto dto= employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}




  
  
  
  


  
  
  
  
  




