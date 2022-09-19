package org.example.demo.controller;

import org.example.demo.exception.NotFoundException;
import org.example.demo.model.BizResponse;
import org.example.demo.model.User;
import org.example.demo.service.Calculator;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    RestTemplate restTemplate = new RestTemplate();


    @ResponseBody
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public BizResponse<List<User>> users() {
        List<User> users = userService.listAll();
        return BizResponse.OK(users);
    }


    @ResponseBody
    @GetMapping("/user/{id}")
    public BizResponse<User>  getUser(@PathVariable("id")Integer id) throws NotFoundException {
        return BizResponse.OK(userService.getById(id));
    }

    //todo 不要在每个方法上加BizResponse


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
