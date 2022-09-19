package org.example.demo.service;

import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.example.demo.exception.NotFoundException;
import org.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);


    private String getDummyLog() {
        StringBuilder sb = new StringBuilder();
        int length = 100000;

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ',', '.', ':', '?', '#', '@', '%'};
        int arrLen = chars.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(arrLen);
            sb.append(chars[index]);
        }

        return sb.toString();
    }

    @Trace
    public List<User> listAll() {
        Random random = new Random();
        long start = System.currentTimeMillis();
        try {
            int i = random.nextInt(5) + 1;
            Thread.sleep(200 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional<String> requestId = TraceContext.getCorrelation("requestId");
        logger.warn(requestId.orElse("requestId") +":"+ "test");

        long elapsed = System.currentTimeMillis() - start;
        logger.debug(" 1debug elapsed:" + elapsed + " ms");
        logger.info(" 2info elapsed:" + elapsed + " ms");
        logger.warn(" 3warn elapsed:" + elapsed + " ms");
        logger.error(" 4error elapsed:" + elapsed + " ms");

        return new ArrayList<User>() {
            {
                add(new User(1, "Tom", "BJ"));
                add(new User(2, "July", "BJ"));
                add(new User(3, "David", "SH"));
            }
        };
    }


    public User getById(int id) throws NotFoundException {
        try {
            if (id < 0) {
                throw new NotFoundException("user not found by id:" + id);
            }

            if (id > 10) {
                throw new RuntimeException("user not found by id:" + id);
            }
            return new User(3, "David", "SH");
        } catch (Exception x){
            logger.info("error");
            throw x;
        }

    }
}
