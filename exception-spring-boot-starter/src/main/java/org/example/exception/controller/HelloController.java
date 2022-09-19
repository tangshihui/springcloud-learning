package org.example.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/add")
    public int add(Integer a, Integer b) {
        return a + b;
    }
}
