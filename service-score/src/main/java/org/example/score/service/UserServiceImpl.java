package org.example.score.service;

import org.example.score.dao.UserDAO;
import org.example.score.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.getUser(id);
    }

    @Override
    public Integer createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userDAO.deleteUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> listAll() {
        return userDAO.listAll();
    }
}
