package com.love2code.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    private String showForm() {
        return "helloworld-form";
    }

    // example getting request param from HttpServetRequest

    /*@GetMapping("/processForm")
    private String processForm(HttpServletRequest request, Model model) {

        // gets url params from the request
        String studentName = request.getParameter("studentName");
        String message = studentName.isEmpty() ? "ya dirty dog" : studentName + ", ya dirty dog";

        model.addAttribute("message", message);

        return "helloworld";
    }*/

    // example of using request param binding using @RequestParam

    @GetMapping("/processForm")
    private String processForm(@RequestParam("studentName") String studentName, Model model) {

        String message = studentName.isEmpty() ? "ya dirty dog" : studentName + ", ya dirty dog";

        model.addAttribute("message", message);

        return "helloworld";
    }
}
