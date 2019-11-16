package com.mashensoft.springboot1.service;

import com.mashensoft.springboot1.model.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUser();

    public User getUser(Integer userId);//mysql，Integer userId

    public boolean saveUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(Integer userId);

}
