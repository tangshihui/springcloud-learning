package org.example.consumer.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider02")
public interface FeignCalculatorService {

    @GetMapping("/calculate")
    int calculate(@RequestParam("a") int a, @RequestParam("b") int b);
}
