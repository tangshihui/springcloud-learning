package org.example.demo.controller;

import org.example.demo.model.User;
import org.example.demo.service.Calculator;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/users")
    public List<User> users() {
        return userService.listAll();
    }



    @GetMapping("/user/{id}/score")
    public String userScore(@PathVariable("id")Integer id) {
        try {
            int i = new Random().nextInt(5) + 1;
            Thread.sleep(100 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForEntity("http://127.0.0.1:9080/user/" + id + "/score", String.class, id).toString();
    }

}
