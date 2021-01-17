package com.cn.travel.role.user.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.role.user.entity.Porvice;
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
/**
 * @title 用户中心模块
 * @description 
 * @author ：linkong
 * @updateTime 2021/1/5 18:52
 * @return 
 * @throws 
 */
    //查找用户id
    @SelectProvider(type = UserSqlProvider.class, method = "findById")
    public User findById(@Param("id") String id);

    //修改用户
    @UpdateProvider(type = UserSqlProvider.class, method = "update")
    public void update(User user);

    //省份
    @SelectProvider(type = UserSqlProvider.class, method = "countPorvice")
    public List<Porvice> countPorvice();

    //所有用户
    @SelectProvider(type = UserSqlProvider.class, method = "count")
    public long count();

    //查询
    @SelectProvider(type = UserSqlProvider.class, method = "findListByQuery")
    public List<User> findListByQuery(@Param("query") String query);

    //查询所用用户，并排序
    @SelectProvider(type = UserSqlProvider.class, method = "findList")
    public List<User> findList();

    //删除
    @UpdateProvider(type = UserSqlProvider.class, method = "deleteByid")
    public void deleteByid(@Param("id")String id);
}
