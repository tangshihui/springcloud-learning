package org.example.consumer.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider01", path = "/hello")
public interface FeignCalculatorService {



    @GetMapping("/{name}")
    String hello(@PathVariable("name") String name);

    @GetMapping("/calculate")
    int calculate(@RequestParam("a") int a, @RequestParam("b") int b);
}
