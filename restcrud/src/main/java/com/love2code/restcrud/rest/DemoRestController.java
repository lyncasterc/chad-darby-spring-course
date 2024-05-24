package com.love2code.restcrud.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    @GetMapping("/hello")
    private ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

}
