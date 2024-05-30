package com.love2code.thymeleafdemo.controller;

import com.love2code.thymeleafdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${favoriteSystems}")
    private List<String> favoriteSystems;

    @GetMapping("/studentForm")
    private String showForm(Model model) {
        Student student = new Student();

        model.addAttribute("student", student);
        this.addCommonAttributes(model);

        return "student-form";
    }

    @PostMapping("/studentForm")
    private String processStudentForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            this.addCommonAttributes(model);

            return "student-form";
        }

        return "student-confirmation";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("favoriteSystems", favoriteSystems);
    }
}
