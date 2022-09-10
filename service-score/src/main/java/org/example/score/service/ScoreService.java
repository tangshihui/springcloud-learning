package org.example.score.service;

import org.example.score.model.User;
import org.example.score.model.UserScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ScoreService {
    private Logger logger = LoggerFactory.getLogger(ScoreService.class);

    public List<UserScore> listAll() {
        long start = System.currentTimeMillis();
        try {
            int i = new Random().nextInt(5) + 1;
            Thread.sleep(200 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long elapsed = System.currentTimeMillis() - start;
        logger.info("elapsed:" + elapsed + " ms");
        return new ArrayList<UserScore>() {
            {
                add(new UserScore(1, BigDecimal.valueOf(99)));
                add(new UserScore(2, BigDecimal.valueOf(96)));
                add(new UserScore(3, BigDecimal.valueOf(98)));
            }
        };
    }
}
