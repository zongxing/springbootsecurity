package com.mashensoft.security.model;


import javax.persistence.*;

@Entity(name = "ms_user")
public class User  {


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id()
    private Integer userId;
    private String username;
    private String password;
    private Integer age;

    public Integer getUerId() {
        return userId;
    }

    public User() {

    }

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User(Integer userId, String username, String password, Integer age) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "userId:" + userId + ",username:" + username + ",password:" + password + ",age:" + age;
    }
}
