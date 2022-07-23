package org.example.hello.controller;

import org.example.hello.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Calculator calculator;


    @Value("${server.port}")
    private int port;


    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello," + name +"/ " + port;
    }


    @GetMapping("/calculate")
    public int calculate(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.add(a, b);
    }
}
