package com.sunp.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.HashMap;
import java.util.Map;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    /**
     * 可以配置加载数据库的备注，省去了配置 xml，初始化的时候会加载
     * @param filterChainDefinitionMap
     */
    @Override
    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
        Map<String,String> filterMap=new HashMap<>();
        //再细致的拼装可以自己改
        filterMap.put("/user/login**","anon");
        filterMap.put("/admin/**","authc,roles[admin],perms[admin:info]");
        filterMap.put(" /super/**","authc,roles[super],perms[super:info]");
        super.setFilterChainDefinitionMap(filterMap);
    }
}
