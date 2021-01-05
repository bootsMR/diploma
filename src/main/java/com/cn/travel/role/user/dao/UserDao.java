package com.cn.travel.role.user.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao extends BaseDao<User> {

    /**
     * @title 前台页面登录
     * @description
     * @author ：linkong
     * @updateTime 2020/11/15 15:54
     * @return
     * @throws
     */
    @SelectProvider(type = UserSqlProvider.class, method = "login")
    public User login(@Param("userName") String userName, @Param("password") String password);


    @SelectProvider(type = UserSqlProvider.class,method = "save")
    public void save(User user);

    //查找用户名
    @SelectProvider(type = UserSqlProvider.class, method = "findByUserName")
    public User findByUserName(@Param("userName") String userName);



}
