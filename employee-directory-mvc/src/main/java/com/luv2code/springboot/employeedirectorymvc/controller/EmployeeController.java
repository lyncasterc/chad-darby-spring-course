package com.luv2code.springboot.employeedirectorymvc.controller;

import com.luv2code.springboot.employeedirectorymvc.entity.Employee;
import com.luv2code.springboot.employeedirectorymvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add-employee")
    private String showEmployeeForm(Model model) {
        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);

        return "employee-form";
    }


    @PostMapping("/add-employee")
    private String processAddEmployeeForm(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    private String employeesList(Model model) {
        List<Employee> employees = employeeService.findAllOrderByLastNameAsc();
        model.addAttribute("employees", employees);

        return "employees-list";
    }

    @GetMapping("/update/{id}")
    private String showUpdateEmployeeForm(Model model, @PathVariable int id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    private String deleteEmployee(Model model, @PathVariable int id) {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
