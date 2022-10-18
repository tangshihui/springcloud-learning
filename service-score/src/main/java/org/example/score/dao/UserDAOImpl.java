package org.example.score.dao;

import org.example.score.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public UserDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user_info").usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> listAll() {
        return jdbcTemplate.query("select * from user_info", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getUser(Integer id) {
        return jdbcTemplate.queryForObject("select * from user_info where id=?", new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public Integer createUser(User user) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        String INSERT_MESSAGE_SQL = "insert into user_info(name,age,email) values(?,?,?)";
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection
//                    .prepareStatement(INSERT_MESSAGE_SQL);
//            ps.setString(1, user.getName());
//            ps.setInt(2, user.getAge());
//            ps.setString(3, user.getEmail());
//            return ps;
//        }, keyHolder);
//
//        return (Integer) keyHolder.getKey();

        Map<String, Object> parameters = new HashMap<>(3);
        parameters.put("name", user.getName());
        parameters.put("age", user.getAge());
        parameters.put("email", user.getEmail());
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return (Integer) newId;
    }

    @Override
    public Integer deleteUser(User user) {
        return jdbcTemplate.update("delete user_info where id=?", user.getId());
    }

    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update("update user_info set name=?, age=?, email=? where id=?", user.getName(), user.getAge(), user.getEmail(), user.getId());
    }
}
