package com.cn.travel.role.admin.service;

import com.cn.travel.role.admin.entity.Admin;

import java.util.List;

public interface IAdminService {
//查询所有管理员
    public long count()throws Exception;
//登录
    public Admin login(String userName, String password)throws Exception;

//查询具体管理员
    public Admin findById(String id)throws Exception;

//保存
    public void save(Admin admin)throws Exception;

//更新
    public void update(Admin admin)throws Exception;

//删除
    public void deleteByid(String id)throws Exception;

//查询管理员
    public List<Admin> findByPage(int currentPage, int pageSize, String query)throws Exception;
}
