package org.example.score.controller;

import org.example.score.model.UserScore;
import org.example.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/user/{id}/score")
    public UserScore userScore(@PathVariable("id") String id) {
        return scoreService.listAll().stream().filter(x -> x.getUserId().toString().equals(id)).findFirst().get();
    }


    @GetMapping("/scores")
    public List<UserScore> userScores() {
        return scoreService.listAll();
    }


}
