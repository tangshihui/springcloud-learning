package org.example.score.controller;

import org.example.score.model.User;
import org.example.score.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping("/users")
    public List<User> users() {
        return userService.listAll();
    }


    @GetMapping("/user/hello")
    public String  helloUser(String name) {
        return "hello,"+name;
    }

}
