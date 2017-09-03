package com.sunp.model;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 19:03
 * Describe: 用户实体类
 */
public class User implements Serializable{

    public User() {}

    public User(String userId, String userName, String userPassword, String userRemark) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRemark = userRemark;
    }

    private String userId;
    private String userName;
    private String userPassword;
    private String userRemark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }
}
