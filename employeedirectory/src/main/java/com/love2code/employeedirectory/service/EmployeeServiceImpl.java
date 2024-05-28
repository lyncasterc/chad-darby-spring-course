package com.love2code.employeedirectory.service;

import com.love2code.employeedirectory.dao.EmployeeRepository;
import com.love2code.employeedirectory.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    private final EmployeeDAO employeeDAO;

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository
                                       employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
