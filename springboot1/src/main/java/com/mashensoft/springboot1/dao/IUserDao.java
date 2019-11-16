package com.mashensoft.springboot1.dao;

import com.mashensoft.springboot1.model.User;

import java.util.List;

public interface IUserDao {
    public List<User> getAllUser();

    public User getUser(Integer userId);

    public boolean saveUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(Integer userId);

    public boolean deleteTwoUser(Integer userId, Integer userId2);
}
