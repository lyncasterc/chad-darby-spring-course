package com.love2code.employeedirectory.rest;

import com.love2code.employeedirectory.entity.Employee;
import com.love2code.employeedirectory.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{requestId}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable int requestId) {
        Optional<Employee> employee = employeeService.findById(requestId);

        if (employee.isEmpty()) {
//            throw new RuntimeException("Employee id not found");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee.get());
    }

    @PostMapping
    private ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee, UriComponentsBuilder ucb) {
        // in case the id was set to something other than 0
        // which would cause an existing record to be updated rather than creating a new one
        // using the entityManager.merge() method
        newEmployee.setId(0);

        Employee createdEmployee = employeeService.save(newEmployee);

        URI newEmployeeLocation = ucb.path("employees/{id}")
                .buildAndExpand(createdEmployee.getId())
                .toUri();

        return ResponseEntity.created(newEmployeeLocation).body(createdEmployee);
    }

    @PutMapping("/{requestId}")
    private ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable int requestId) {
        Optional<Employee> existingEmployee = employeeService.findById(requestId);

        if (existingEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        updatedEmployee.setId(requestId);
        employeeService.save(updatedEmployee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{requestId}")
    private ResponseEntity<Void> deleteEmployeeById(@PathVariable int requestId) {
        Optional<Employee> employee = employeeService.findById(requestId);

        if (employee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        employeeService.deleteById(requestId);

        return ResponseEntity.noContent().build();
    }
}
