package org.example.score.service;

import org.example.score.dao.UserDAO;
import org.example.score.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> listAll();
    User getUser(Integer id);

    Integer createUser(User user);

    Integer deleteUser(User user);

    int updateUser(User user);
}
