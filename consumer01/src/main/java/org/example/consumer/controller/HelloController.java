package org.example.consumer.controller;

import org.example.consumer.feign.service.FeignCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consume")
public class HelloController {

    @Autowired
    private FeignCalculatorService calculatorService;


    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return calculatorService.hello(name);
    }


    @GetMapping("/calculate")
    public int hello(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorService.calculate(a, b);
    }
}
