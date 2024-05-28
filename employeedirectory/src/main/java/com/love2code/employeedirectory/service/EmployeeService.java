package com.love2code.employeedirectory.service;

import com.love2code.employeedirectory.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
