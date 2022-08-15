package org.example.provider02.controller;

import org.example.provider02.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private Calculator calculator;

    @Value("${server.port}")
    private int port;


    @GetMapping("/calculate")
    public int calculate(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.add(a, b);
    }
}
