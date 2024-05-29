package com.love2code.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@Controller
public class DemoController {
    @GetMapping("/hello")
    private String helloWorld(Model model) {

        model.addAttribute("theDate", LocalDateTime.now());

        return "helloworld";
    }
}
