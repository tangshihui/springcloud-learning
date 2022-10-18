package org.example.score.dao;

import org.example.score.model.User;
import org.example.score.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface UserDAO {
    List<User> listAll();

    User getUser(Integer id);

    Integer createUser(User user);

    Integer deleteUser(User user);

    int updateUser(User user);
}
