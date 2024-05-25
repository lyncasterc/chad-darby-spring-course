package com.love2code.restcrud.rest;

import com.love2code.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    // hard coded for now
    private HashMap<Integer, Student> studentHashMap;

    @PostConstruct
    private void populateMockData() {
        this.studentHashMap = new HashMap<>();

        this.studentHashMap.put(0, new Student("John", "Doe"));
        this.studentHashMap.put(1, new Student("Jane", "Dane"));
        this.studentHashMap.put(2, new Student("Bobby", "Robby"));
    }

    @GetMapping
    private ResponseEntity<List<Student>> getStudents() {

        List<Student> students = new ArrayList<>(this.studentHashMap.values());

        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    private ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = this.studentHashMap.get(studentId);

        if (student == null) {
            throw new StudentNotFoundException("studentId not found: " + studentId);
        }

        return ResponseEntity.ok(student);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exception.getMessage());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // catch all exception handler


    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse response = new StudentErrorResponse();

        response.setMessage(exception.getMessage());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.badRequest().body(response);
    }
}
