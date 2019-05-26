package com.lw.rbac;

import com.lw.rbac.domain.User;
import com.lw.rbac.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RbacApplicationTests {

    @Test
    public void contextLoads() {
    }



    @Autowired
    UserService userService;

    @Test
    public void userTest(){
        User user = new User();
        user.setPassword("1759840027");
        user.setPhone("17803878845");
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setName("李伟");
        System.out.println(userService.save(user));

    }

    @Test
    @Transactional
    public void loginTest(){
        User user = userService.login("17803878845","1759840027");
        System.out.println(user);
    }

}
