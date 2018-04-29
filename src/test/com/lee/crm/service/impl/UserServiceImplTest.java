package com.lee.crm.service.impl;

import com.lee.crm.model.User;
import com.lee.crm.service.UserException;
import com.lee.crm.service.UserServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceImplTest {


    @Autowired
    private UserServiceInterface mUserServiceInterface;

    @Test
    public void register() {
        User form = new User();
        form.setUsername("测试用户名1");
        form.setPassword("测试用户密码1");
        try {
            mUserServiceInterface.register(form);
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
    }
}