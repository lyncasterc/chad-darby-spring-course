package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            // example of creating and retrieving a student by id

            /*Student student = createAndReturnStudent(studentDAO);
            Student retrievedStudent = studentDAO.findById(student.getId());
            System.out.println("Retrieved student: " + retrievedStudent);*/


            // example of creating multiple students and retrieving all students
           /* createMultipleStudents(studentDAO);
            List<Student> students = studentDAO.findAll();
            students.forEach(student -> System.out.println(student));*/


            // example of creating multiple students and retrieving one by last name

            createMultipleStudents(studentDAO);
            List<Student> students = studentDAO.findByLastName("C");
            students.forEach(student -> System.out.println(student));

            // example of updating a student's first name

            /*Student student = createAndReturnStudent(studentDAO);
            student.setFirstName("Jane");

            studentDAO.update(student);

            Student updatedStudent = studentDAO.findById(student.getId());

            System.out.println(updatedStudent.getFirstName());*/

            // example of deleting one student by id

           /* createMultipleStudents(studentDAO);
            Student student = (studentDAO.findByLastName("C")).getFirst();
            studentDAO.deleteById(student.getId());*/

            // example of deleting student by lastname

           /* createMultipleStudents(studentDAO);

            studentDAO.deleteByLastName("C");

            List<Student> students = studentDAO.findAll();

            students.forEach(student -> System.out.println(student));

            studentDAO.deleteAll();*/
        };
    }

    private static Student createAndReturnStudent(StudentDAO studentDAO) {
        System.out.println("Creating student...");

        Student tempStudent = new Student("John", "Doe", "john@doe.com");

        System.out.println("Saving student...");

        studentDAO.save(tempStudent);

        return tempStudent;
    }

    private static void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating students...");


        Student tempStudent1 = new Student("John", "A", "john@doe.com");
        Student tempStudent2 = new Student("Jane", "B", "jane@doe.com");
        Student tempStudent3 = new Student("Bob", "C", "bob@doe.com");

        System.out.println("Saving students...");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }
}
