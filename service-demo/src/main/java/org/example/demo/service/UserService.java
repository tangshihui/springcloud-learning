package org.example.demo.service;

import org.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> listAll() {
        long start = System.currentTimeMillis();
        try {
            int i = new Random().nextInt(5) + 1;
            Thread.sleep(200 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long elapsed = System.currentTimeMillis() - start;
        logger.info("elapsed:" + elapsed + " ms");
        return new ArrayList<User>() {
            {
                add(new User(1, "Tom", "BJ"));
                add(new User(2, "July", "BJ"));
                add(new User(3, "David", "SH"));
            }
        };
    }
}
