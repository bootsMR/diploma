package com.cn.travel.role.user.service;

import com.cn.travel.role.user.entity.User;

import java.util.List;

public interface IUserService {

//登录
    public User login(String userName, String password)throws Exception;

//注册
    public void save(User user)throws Exception;
//查找用户名
    public User findByUserName(String userName)throws Exception;


}
