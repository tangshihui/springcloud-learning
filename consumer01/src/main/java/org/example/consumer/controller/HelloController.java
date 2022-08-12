package org.example.consumer.controller;

import org.example.consumer.feign.service.FeignCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consume")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private FeignCalculatorService calculatorService;


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");

        return calculatorService.hello(name);
    }


    @GetMapping("/calculate")
    public int hello(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculatorService.calculate(a, b);
    }
}
