package com.example.springboot2.springboot2postgresqljpahibernatecrud.controller;


import com.example.springboot2.springboot2postgresqljpahibernatecrud.exception.ResourceNotFoundException;
import com.example.springboot2.springboot2postgresqljpahibernatecrud.model.Employee;
import com.example.springboot2.springboot2postgresqljpahibernatecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/Gets")
    public List<Employee>  getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employees = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping("/create")
    public Employee createEmployees(@Validated @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable(value = "id") Long employeeId,
                                                   @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteEmployees(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
