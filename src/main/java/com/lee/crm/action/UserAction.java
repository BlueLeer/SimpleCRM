package com.lee.crm.action;

import com.lee.crm.model.User;
import com.lee.crm.service.UserException;
import com.lee.crm.service.UserServiceInterface;
import com.lee.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */

public class UserAction extends BaseAction implements ModelDriven<User> {
    private User user = new User();

    @Autowired
    private UserServiceInterface mUserService;

    /**
     * 用户登录
     *
     * @return
     */
    public String login() {
        // 首先校验验证码
        String correctCode = (String) getSession().get("session_verifycode");
        if (correctCode == null || correctCode.isEmpty()) {
            getRequest().put("msg", "服务器错误!!");
            return ERROR;
        }

        if (!correctCode.equalsIgnoreCase(user.getVerifycode())) {
            getRequest().put("msg", "验证码错误!");
            return ERROR;
        }

        try {
            User login = mUserService.login(user);
            // 登录成功,将成功信息写入到request中,并将User对象保存到session中
            getRequest().put("msg", "登录成功!");
            getSession().put("session_user", login);
        } catch (UserException e) {
            e.printStackTrace();
            getRequest().put("msg", e.getMessage());
            return ERROR;
        }

        return SUCCESS;
    }

    /**
     * 用户注册
     *
     * @return
     */
    public String register() {
        try {
            User register = mUserService.register(user);
            getRequest().put("msg", "注册成功!");
            getSession().put("session_user", register);
        } catch (UserException e) {
            getRequest().put("msg", e.getMessage());
            e.printStackTrace();

            return ERROR;
        }

        return SUCCESS;
    }

    /**
     * 用户注销(未实现)
     *
     * @return
     */
    public String cancel() {
        return null;
    }

    @Override
    public User getModel() {
        return user;
    }
}
