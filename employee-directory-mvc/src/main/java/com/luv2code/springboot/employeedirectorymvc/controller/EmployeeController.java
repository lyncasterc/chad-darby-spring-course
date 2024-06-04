package com.luv2code.springboot.employeedirectorymvc.controller;

import com.luv2code.springboot.employeedirectorymvc.entity.Employee;
import com.luv2code.springboot.employeedirectorymvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    private String employeesList(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "employees-list";
    }


}
