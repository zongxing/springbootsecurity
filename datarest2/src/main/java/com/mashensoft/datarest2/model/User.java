package com.mashensoft.datarest2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @GeneratedValue
    @Id
    private Integer userid;
    private String username;
    private String password;
    private Integer age;

    public Integer getUserid() {
        return userid;
    }

    public User() {

    }

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User(Integer userid, String username, String password, Integer age) {
        this.userid = userid;
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
        return "userid:" + userid + ",username:" + username + ",password:" + password + ",age:" + age;
    }
}
