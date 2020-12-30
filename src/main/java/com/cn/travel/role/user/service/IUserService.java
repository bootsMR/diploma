package com.cn.travel.role.user.service;

import com.cn.travel.role.user.entity.User;

import java.util.List;

public interface IUserService {

/**
 * @title 前台页面登录
 * @description 
 * @author ：linkong
 * @updateTime 2020/11/15 15:54 
 * @return 
 * @throws 
 */
    public User login(String userName, String password)throws Exception;

    public List<User> findList()throws Exception;

    public User findByUserName(String userName)throws Exception;

    public void save(User user)throws Exception;

}
