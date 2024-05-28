package com.love2code.employeedirectory.dao;

import com.love2code.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
