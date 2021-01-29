package com.example.system.dao;

import com.example.system.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getUserTest(){
        UserEntity t = userDao.findByUserNameAndPassWord("xb", "123");
        System.out.println(t);
    }
}