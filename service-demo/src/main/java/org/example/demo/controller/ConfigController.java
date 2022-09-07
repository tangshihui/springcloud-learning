package org.example.demo.controller;


import org.example.demo.config.YamlConfig;
import org.example.demo.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/config")
public class ConfigController {

    public String server;

    public String port;



    @GetMapping("/")
    public String hello() {
        return "server:" + server + "/ port:" + port;
    }


    @GetMapping("/{dataId}")
    public String getUtilityConfig(@PathVariable("dataId") String dataId, @RequestParam(value = "group", required = false) String group) {
        return dataId;
    }




}
