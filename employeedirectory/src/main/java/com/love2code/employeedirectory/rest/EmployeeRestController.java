package com.love2code.employeedirectory.rest;

import com.love2code.employeedirectory.entity.Employee;
import com.love2code.employeedirectory.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    private ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll();

        return ResponseEntity.ok(employees);
    }
}
