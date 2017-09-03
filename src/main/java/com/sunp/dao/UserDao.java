package com.sunp.dao;

import com.sunp.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 18:21
 * Describe: 用户数据 dao 接口
 */
public interface UserDao {

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
