package com.love2code.employeedirectory.dao;

import com.love2code.employeedirectory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        // if the id is 0, it inserts new employee
        // otherwise, it updates the existing employee
        Employee newOrUdpatedEmployee = entityManager.merge(employee);

        return newOrUdpatedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = this.findById(id);

        entityManager.remove(employee);
    }
}
