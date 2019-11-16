package com.mashensoft.springboot1.service;

import com.mashensoft.springboot1.dao.IUserDao;
import com.mashensoft.springboot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserDao userDao;
    public String username = "abc";

    @Override
    public List<User> getAllUser() {

        return userDao.getAllUser();
    }

    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }
}
