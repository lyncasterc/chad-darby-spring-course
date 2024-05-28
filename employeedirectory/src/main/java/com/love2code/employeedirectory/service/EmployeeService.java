package com.love2code.employeedirectory.service;

import com.love2code.employeedirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
}
