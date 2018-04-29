package com.lee.crm.service;

import com.lee.crm.model.User;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public interface UserServiceInterface {
    /**
     * 注册
     *
     * @param form
     * @return 登录成功的用户, 该用户是持久化对象, 包含对象ID
     */
    User register(User form) throws UserException;

    /**
     * 登录
     *
     * @param form
     * @return 返回登录成功的用户, 该User对象是持久化对象, 包含对象ID
     */
    User login(User form) throws UserException;

    /**
     * 注销
     *
     * @param user
     * @return 已经注销的用户
     */
    User cancel(User user);
}
