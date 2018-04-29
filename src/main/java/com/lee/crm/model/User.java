package com.lee.crm.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description: 系统的用户对应的实体类
 */
@Entity
@Table(name = "crm_user")
public class User implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private String verifycode;

    public User() {
    }

    public User(Long userId, String username, String password, String verifycode) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.verifycode = verifycode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Ignore
    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifycode='" + verifycode + '\'' +
                '}';
    }
}
