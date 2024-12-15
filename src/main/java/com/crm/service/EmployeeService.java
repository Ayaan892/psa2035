package com.crm.service;

import com.crm.entity.Employee;
import com.crm.exception.ResourceNotFound;
import com.crm.payload.EmployeeDto;
import com.crm.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDto addEmployee(EmployeeDto dto){
        Employee employee =mapToEntity(dto);
        Employee emp = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDTO(emp);
        return employeeDto;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto dto) {
        Optional<Employee> opEmp = employeeRepository.findById(id);
        Employee employee = opEmp.get();
        employee.setName(dto.getName());
        employee.setEmailId(dto.getEmailId());
        employee.setMobile(dto.getMobile());
        employeeRepository.save(employee);
    }

    public List<EmployeeDto> getEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dto= employees.stream().map(e ->mapToDTO(e)).collect(Collectors.toList());
        return dto;
    }
    EmployeeDto mapToDTO(Employee employee){

        EmployeeDto dto = modelMapper.map(employee,EmployeeDto.class);
//        EmployeeDto dto = new EmployeeDto();
//        dto.setId(employee.getId());
//        dto.setName(employee.getName());
//
//        dto.setEmailId(employee.getEmailId());
//        dto.setMobile(employee.getMobile());
        return dto;

    }
    Employee mapToEntity(EmployeeDto dto) {
        Employee emp=modelMapper.map(dto,Employee.class);
//        Employee emp = new Employee();
//        emp.setId(dto.getId());
//        emp.setName(dto.getName());
//        emp.setEmailId(dto.getEmailId()); //map the
//        emp.setMobile(dto.getMobile());
        return emp;
    }


    public EmployeeDto getEmployeeById(Long empId) {
//        Optional<Employee> opEmp = employeeRepository.findById(empId);
//        Employee employee = opEmp.get();
//        return mapToDTO(employee);
               Employee employee = employeeRepository.findById(empId).orElseThrow(
                       ()->new ResourceNotFound("Resource Not found with id"+ empId)  //ExceptionSupplier()
                       // : it  only produces output ,it doent take an input
               );

               EmployeeDto dto= mapToDTO(employee);
               return dto;
    }

}





