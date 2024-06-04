package com.luv2code.springboot.employeedirectorymvc.service;

import com.luv2code.springboot.employeedirectorymvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllOrderByLastNameAsc();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
