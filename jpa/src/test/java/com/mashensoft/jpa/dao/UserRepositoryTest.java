package com.mashensoft.jpa.dao;

import com.mashensoft.jpa.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @BeforeEach
    void setUp() {
    }








    /**
     * 查询所有的数据
     */
    @Test
    void testFindAll(){
        assertEquals(4,userRepository.findAll().size());
    }
    /**
     * 查询一条数据
     */

    @Test
    void testFindById(){
        Optional<User> user = userRepository.findById(2);
        assertEquals(2,user.get().getUserid());
    }
    @Transactional
    @Test
    void testSave(){
        User user = new User("mashensoft","123",18);
        User resultUser = userRepository.save(user);
        assertEquals("mashensoft",resultUser.getUsername());
    }
    @Transactional
    @Test
    void testUpdate(){
        User user = new User(12,"xingge","666",18);
        User resultUser = userRepository.save(user);
        assertEquals("666",resultUser.getPassword());
    }
    @Transactional
    @Test
    void testDelete(){
        User user = new User();
        user.setUserid(12);
        userRepository.delete(user);
    }
    @Test
    void testDeleteById(){
        userRepository.deleteById(12);
    }
//    @Test
//    void testQuery(){
//       // Example example = new Example
//       // userRepository.findAll(4);
////        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("username",match->match.startsWith());
////        userRepository.findAll(matcher);
//    }
//    @Test
//    void testFindByUsername(){
//        assertEquals(1,userRepository.findByUsername("mashen").size());
//    }
//    @Test
//    void testFindByUsernameAndPassword(){
//        assertEquals(1,userRepository.findByUsernameAndPassword("mashen","123").size());
//    }
//    @Test
//    void testFindByUsernameLikeAndPassword(){
//        assertEquals(2,userRepository.findByUsernameLikeAndPassword("%e%","123").size());
//    }
//    @Test
//    void testFindByUsernameLikeOrPassword(){
//        assertEquals(4,userRepository.findByUsernameLikeOrPassword("%e%","332dd").size());
//    }
//    @Test
//    void testFindByUsernameLike(){
//        assertEquals(2,userRepository.findByUsernameLike("%s%").size());
//    }
//////    @Test
//////    void testFindByUsernameOrPassword(){
//////        assertEquals(2,userRepository.findByUsernameOrPassword("mashensoft","123").size());
//////    }
//    @Test
//    void testFindByUsername(){
//        assertEquals(1,userRepository.findByUsername2("mashensoft").size());
//    }
//
//    @Test
//    void testSaveUser(){
////        userRepository.saveUser("mashensoft","888",18);
//        assertEquals(1,userRepository.saveUser("mashensoft","888",18));
//    }
//    @Transactional
//    @Test
//    void testDeleteUser(){
//        assertEquals(1,userRepository.deleteUser("mashensoft"));
//    }
    @Transactional
    @Test
    void testFindByName(){
        assertEquals(2,userRepository.findByName("mashen").size());
    }
    @Transactional
    @Test
    void testFindByName2(){
        assertEquals(2,userRepository.findByUsername2("mashen").size());
    }
    @Test
    void testSaveUser(){
        assertEquals(1,userRepository.saveUser("mashen123","666",5));
    }
    @Test
    void testUpdateUser(){
        assertEquals(1,userRepository.updateUser("mashen123","666",5,11));
    }
    static Logger log= LoggerFactory.getLogger(UserRepositoryTest.class);


    @Transactional
    @Test
    void testDeleteUser(){
        log.debug("this is mashensoft debug");
        log.info("this is mashensoft log");
        assertEquals(1,userRepository.deleteUser("mashen"));
    }


}