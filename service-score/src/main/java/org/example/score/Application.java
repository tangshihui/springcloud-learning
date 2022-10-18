package org.example.score;


import org.example.score.config.MysqlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(org.example.score.Application.class);

    @Autowired
    private MysqlProperties mysqlProperties;

//    @Autowired
//    ExceptionResponseRuleFactory factory;

//    ExceptionResponseRuleFactory factory;
//
//    public Application(@Autowired ExceptionResponseRuleFactory factory) {
//        this.factory = factory;
//    }

    public static void main(String[] args) {
        System.out.println("this is main ...");
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("service score adding exception rule ...");
    }
}
