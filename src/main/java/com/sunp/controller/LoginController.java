package com.sunp.controller;

import com.sunp.model.User;
import com.sunp.service.UserService;
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

    private Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserList(){
        logger.info("user/getUserList init");
        Map<String,Object> map=new HashMap<>();
        map.put("users",userService.getUserList());
        return map;
    }
}
