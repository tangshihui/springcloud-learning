package org.example.score.controller;

import org.example.score.model.User;
import org.example.score.service.UserService;
import org.h2.engine.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public int addUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PutMapping("/user")
    public boolean update(@RequestBody User user) {
        if (user.getId() > 10) {
            throw new RuntimeException("invalid user id");
        }
        int rows = userService.updateUser(user);
        return rows > 0;
    }


    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        if (id > 10) {
            throw new RuntimeException("invalid user id");
        }

        User user = new User();
        user.setId(id);
        return userService.deleteUser(user) > 0;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        if (id > 10) {
            throw new RuntimeException("invalid user id");
        }

        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> users() {
        return userService.listAll();
    }


    @GetMapping("/div")
    public int div(Integer num) {
        int res = 3 / num;

        return res;
    }


    @GetMapping("/div2")
    public int divWithException(Integer num) {
        if (num == 0) {
            throw new RuntimeException("num must > 0");
        }
        int res = 3 / num;

        return res;
    }


//
//
//    @OverrideResponseMeta(requestBody = "test post body")


    @GetMapping("/user/hello")
    public String helloUser(String name) {
        return "hello," + name;
    }

}
