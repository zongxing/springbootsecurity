package com.mashensoft.springboot1.dao;

import com.mashensoft.springboot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源，仓库
 * spring初始化，生成对象，默认是单例的。
 */
//@Transactional(timeout=30,isolation = Isolation.REPEATABLE_READ,rollbackFor={Exception.class},noRollbackFor={RuntimeException.class})
@Transactional
@Repository
public class UserDaoMysql implements IUserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList();
        list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public User getUser(Integer userId) {
        User user = jdbcTemplate.queryForObject("select * from user where userId=?", new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        jdbcTemplate.update("insert into user (username,password,age) values(?,?,?)", new Object[]{user.getUsername(), user.getPassword(), user.getAge()});
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        jdbcTemplate.update("update user set username=?,password=?,age=? where userId=?", new Object[]{user.getUsername(), user.getPassword(), user.getAge(), user.getUserId()});
        return true;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        jdbcTemplate.update("delete from user where userId=?", new Object[]{userId});
        return true;
    }

    @Transactional
    @Override
    public boolean deleteTwoUser(Integer userId, Integer userId2) {
        jdbcTemplate.update("delete from user where userId=?", new Object[]{userId});
        int a = 5 / 0;//删除一条数据之后，出现了不可控制的异常
        jdbcTemplate.update("delete from user where userId=?", new Object[]{userId});
        return true;
    }
}
