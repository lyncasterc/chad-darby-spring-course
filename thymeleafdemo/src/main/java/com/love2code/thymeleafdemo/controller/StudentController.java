package com.love2code.thymeleafdemo.controller;

import com.love2code.thymeleafdemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // initbinder methods run before any request handler methods do
    @InitBinder private void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

    //@Valid annotation tells Spring MVC to validate fields against any constraints
    // BindingResult will contain any errors
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
