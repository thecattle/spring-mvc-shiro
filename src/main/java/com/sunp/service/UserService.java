package com.sunp.service;

import com.sunp.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 19:18
 * Describe:
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    User getUserInfo(String userName);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();
}
