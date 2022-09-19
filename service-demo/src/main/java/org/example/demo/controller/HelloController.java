package org.example.demo.controller;

import org.example.demo.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Calculator calculator;


    @Value("${server.port}")
    private int port;



    //将返回String的ContentType变成“application/json; charset=UTF-8“
    //否则默认返回的contentType是text/plain
    @ResponseBody
    //@GetMapping(value = "/hello/{name}") //返回的contentType是text/plain
    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable("name") String name) {
        return "Hello," + name +"/ " + port;
    }


    @GetMapping("/calculate")
    public int calculate(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.add(a, b);
    }
}
