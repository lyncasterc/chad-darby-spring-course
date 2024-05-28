package com.love2code.employeedirectory.dao;

import com.love2code.employeedirectory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
}
