package com.sunp.dao.impl;

import com.sunp.dao.UserDao;
import com.sunp.model.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
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
        User user1=new User("1",
                "admin",
                "qWdiGI6l8lHjpCXOSrEWOD4UX2gguGTim3hqJVe6nOc=",
                "9Se1CbOxZNFC7a9PaiKZCQ==",
                "管理员");

        User user2=new User("2",
                "super",
                "password",
                "",
                "超级管理员");
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

    /**
     * 模拟创建用户时候存入的密码和盐
     * @param password
     */
    private void credent(String password){

        //散列随机数
        String salt = new SecureRandomNumberGenerator().nextBytes().toBase64();
        //散列迭代次数
        int hashIterations=1024;

        /*
        shiro.xml 中  storedCredentialsHexEncoded=true 则需要 .toHex()
        shiro.xml 中  storedCredentialsHexEncoded=false 则需要 .toBase64()
         */
        String encodedPassword = new Sha256Hash(password, salt, hashIterations).toBase64();
        /*
            效果等同于上句代码
            SimpleHash hash = new SimpleHash("SHA-256", password, salt, hashIterations);
         */
        System.out.println("encodedPassword:"+encodedPassword);
        System.out.println("salt:"+salt);
    }

    public static void main(String[] args) {
        UserDaoImpl myRealm=new UserDaoImpl();
        // 用户的密码为"password",现在把它加密
        myRealm.credent("password");
    }
}
