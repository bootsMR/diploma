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
//查找用户id
    public User findById(String id)throws Exception;

//修改用户
    public void update(User user)throws Exception;

    //查询
    public List<User> findByPage(int currentPage,int pageSize, String query)throws Exception;

    //删除用户
    public void deleteByid(String id)throws Exception;

}
