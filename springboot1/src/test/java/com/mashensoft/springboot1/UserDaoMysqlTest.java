package com.mashensoft.springboot1;

import com.mashensoft.springboot1.dao.IUserDao;
import com.mashensoft.springboot1.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class UserDaoMysqlTest {
    @Autowired
    IUserDao userDao;

    @Test
    void getAllUser() {
        assertEquals(1, userDao.getAllUser().size());
    }

    @Test
    void getUser() {
        assertEquals(1, userDao.getUser(1).getUserId());
    }

    @Transactional
    @Test
    void saveUser() {
        assertEquals(true, userDao.saveUser(new User("xingge", "123", 18)));
    }

    @Test
    void updateUser() {
        assertEquals(true, userDao.updateUser(new User(1, "ms11", "123", 18)));
    }

    @Transactional
    @Test
    void deleteUser() {

        assertEquals(true, userDao.deleteUser(3));
    }

    @Test
    void deleteTwoUser() {
        assertEquals(true, userDao.deleteTwoUser(2, 3));
    }
}