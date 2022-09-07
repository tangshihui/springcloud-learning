package org.example.demo.controller;

import org.example.demo.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Calculator calculator;


    @Value("${server.port}")
    private int port;


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello," + name +"/ " + port;
    }


    @GetMapping("/calculate")
    public int calculate(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.add(a, b);
    }
}
