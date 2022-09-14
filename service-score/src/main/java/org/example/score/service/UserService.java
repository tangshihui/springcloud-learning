package org.example.score.service;

import org.example.score.dao.UserDAO;
import org.example.score.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> listAll() {
        return  new UserDAO().listAll();
    }
}
