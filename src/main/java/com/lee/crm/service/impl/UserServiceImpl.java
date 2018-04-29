package com.lee.crm.service.impl;

import com.lee.crm.dao.DaoInterface;
import com.lee.crm.model.User;
import com.lee.crm.service.UserException;
import com.lee.crm.service.UserServiceInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
@Component
public class UserServiceImpl implements UserServiceInterface {

    @Resource(name = "baseDao")
    private DaoInterface<User> mUserDaoInterface;

    @Override
    public User register(User form) throws UserException {
        // 先从数据库查询相同用户名的用户,如果查询到了,抛出异常
        String hql = "from User where username = ?";
        User user = mUserDaoInterface.get(hql, form.getUsername());
        if (user != null) {
            throw new UserException("用户已被注册!");
        } else {
            // 没有查询出同名的用户,予以注册
            mUserDaoInterface.add(form);
        }

        return form;
    }

    @Override
    public User login(User form) throws UserException {
        // 从数据库查询用户,如果查询到了则予以登录
        // 先按照用户名查询
        String hql = "from User where username = ?";
        User user = mUserDaoInterface.get(hql, form.getUsername());
        if (user == null) {
            throw new UserException("用户名错误!");
        }

        // 校验用户密码
        if (!form.getPassword().trim().equals(user.getPassword())) {
            throw new UserException("用户密码错误!");
        }

        // 放行,返回User对象
        return user;
    }

    /**
     * 用户注销(未实现)
     *
     * @param user
     * @return
     */
    @Override
    public User cancel(User user) {
        return null;
    }
}
