package com.sunp.controller;

import com.sunp.model.User;
import com.sunp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/3
 * Time: 17:21
 * Describe: 用户数据 dao 接口实现
 */

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    //方便调试 直接用 get
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        logger.info("开始登录");
        //构建登录 token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //设置记住我
        token.setRememberMe(true);
        //获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login(token);
            //判断用户状态是否已经被认证
            if (currentUser.isAuthenticated()) {
                map.put("msg", "登录成功");
            } else {
                map.put("msg", "系统异常，请重试");
            }
        } catch (UnknownAccountException uae) {
            map.put("msg", "未知用户");
        } catch (IncorrectCredentialsException ice) {
            map.put("msg", "认证失败");
        } catch (LockedAccountException lae) {
            map.put("msg", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            map.put("msg", "登录失败次数过多");
        } catch (AuthenticationException ae) {
            map.put("msg", "ae.getMessage()");
        }

        return map;
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList() {
        logger.info("user/getUserList init");
        Map<String, Object> map = new HashMap<>();
        map.put("users", userService.getUserList());
        return map;
    }
}
