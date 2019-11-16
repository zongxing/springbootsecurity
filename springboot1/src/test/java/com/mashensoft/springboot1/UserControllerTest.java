package com.mashensoft.springboot1;

import com.mashensoft.springboot1.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController userController;

    @Test
    void user() {
        //assertEquals(2,userController.user().size());
    }


}