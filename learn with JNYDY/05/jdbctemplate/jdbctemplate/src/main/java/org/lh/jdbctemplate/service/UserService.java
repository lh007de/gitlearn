package org.lh.jdbctemplate.service;

import com.fasterxml.jackson.databind.BeanProperty;
import org.lh.jdbctemplate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/24 14:50
 * @Version: 1.0
 **/
@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addUser(User user){
        int update = jdbcTemplate.update("insert into user(name,age) values (?,?);", user.getName(), user.getAge());
        return update;
    }

    public int updateUserById(User user){
        int update = jdbcTemplate.update("update user set name = ?  where id = ? ;", user.getName(), user.getId());
        return update;
    }

    public int deleteUser(User user){
        int update = jdbcTemplate.update("delete  from user where id = ?", user.getId());
        return update;
    }

    public List<User> getAllUsers(){
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setId(resultSet.getLong("id"));
                return user;
            }
        });
    }

    public List<User> getUserList(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
