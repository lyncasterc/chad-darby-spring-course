package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void deleteAll();
}
