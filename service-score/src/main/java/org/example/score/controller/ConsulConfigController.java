package org.example.score.controller;


import org.example.score.config.MysqlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulConfigController {
    @Autowired
    private MysqlProperties mysqlProperties;

//    @Value("${name}")
//    private String name;
//
//    @GetMapping("/name")
//    public String getName() {
//        return name;
//    }

    @GetMapping("/mysql")
    public MysqlProperties getMysqlProperties() {
        return mysqlProperties;
    }
}
