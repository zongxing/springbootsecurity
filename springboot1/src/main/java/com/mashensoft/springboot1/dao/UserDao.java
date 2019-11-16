package com.mashensoft.springboot1.dao;

import com.mashensoft.springboot1.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源，仓库
 * spring初始化，生成对象，默认是单例的。
 */

public class UserDao implements IUserDao {
    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList();
        list.add(new User(111, "mashensoft", "123", 5));
        list.add(new User(222, "xingge", "123", 17));
        return list;
    }

    @Override
    public User getUser(Integer userId) {
        User user = new User(userId, "mashensoft" + userId, "123", 16);
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        System.out.println(user.toString());
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        System.out.println(user.toString());
        return true;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        System.out.println(userId);
        return true;
    }

    @Override
    public boolean deleteTwoUser(Integer userId, Integer userId2) {
        return false;
    }
}
