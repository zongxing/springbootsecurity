package com.mashensoft.springboot1;

import com.mashensoft.springboot1.dao.IUserDao;
import com.mashensoft.springboot1.model.MyObject;
import com.mashensoft.springboot1.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {
    @Autowired
    IUserDao userDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * 测试所有的用户的数量
     */
    @Test
    void getAllUser() {
        assertEquals(2, userDao.getAllUser().size());
    }

    /**
     * 测试返回值为null的情况
     */
    @Test
    void getAllUserIsNull() {
//        assertNotNull(userDao.getAllUser());
        assertNotNull(userDao.getAllUser());
    }

    @Test
    void getUser() {
        assertEquals(1, userDao.getUser(1).getUserId());
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUserId(123);
        assertTrue(userDao.saveUser(user));
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setUserId(123);
        assertTrue(userDao.updateUser(user));
    }

    @Test
    void deleteUser() {
        assertTrue(userDao.deleteUser(1));
    }

    @Autowired
    MyObject myObject;


    @Test
    void stringTest() throws IOException {
        Scanner s = new Scanner(myObject.getResource().getInputStream());
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }
}