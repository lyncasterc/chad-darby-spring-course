package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // exposing the "/" endpoint

    @GetMapping("/")
    public String sayHelloWorld() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "<h2>Run! Harder!</h2>";
    }

    // using custom properties defined in application.properties

    @Value("${developer.name}")
    private String developerName;

    @GetMapping("/devname")
    public String getDeveloperName() {
        return developerName;
    }
}
