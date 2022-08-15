package org.example.consumer.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider-hello", path = "/hello")
public interface FeignHelloService {

    @GetMapping("/{name}")
    String hello(@PathVariable("name") String name);

}
