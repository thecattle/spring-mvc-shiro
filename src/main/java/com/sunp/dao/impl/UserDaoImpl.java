package com.sunp.dao.impl;

import com.sunp.dao.UserDao;
import com.sunp.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 18:25
 * Describe: 用户数据 dao 接口实现
 */

@Component
public class UserDaoImpl implements UserDao {

    private static List<User> users=null;

    /**
     * 初始化假的用户数据
     */
    static {
        users=new ArrayList<>();
        User user1=new User("1","admin","password","管理员");
        User user2=new User("2","super","password","超级管理员");
        users.add(user1);
        users.add(user2);
    }
    @Override
    public User getUserInfo(String userName) {
        for (User user:users) {
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        return users;
    }
}
