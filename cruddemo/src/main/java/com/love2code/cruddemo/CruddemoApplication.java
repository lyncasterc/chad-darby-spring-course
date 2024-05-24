package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            studentDAO.deleteAll();
//            Student student = createAndReturnStudent(studentDAO);
//
//            Student retrievedStudent = studentDAO.findById(student.getId());
//
//            System.out.println("Retrieved student: " + retrievedStudent);

            createMultipleStudents(studentDAO);

            List<Student> students = studentDAO.findAll();

            students.forEach(student -> System.out.println(student));

            studentDAO.deleteAll();
        };
    }

    private static Student createAndReturnStudent(StudentDAO studentDAO) {
        System.out.println("Creating student...");

        Student tempStudent =  new Student("John", "Doe", "john@doe.com");

        System.out.println("Saving student...");

        studentDAO.save(tempStudent);

        return tempStudent;
    }

    private static void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating students...");


        Student tempStudent1 =  new Student("John", "Doe", "john@doe.com");
        Student tempStudent2 =  new Student("Jane", "Doe", "jane@doe.com");
        Student tempStudent3 =  new Student("Bob", "Doe", "bob@doe.com");

        System.out.println("Saving students...");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }
}
