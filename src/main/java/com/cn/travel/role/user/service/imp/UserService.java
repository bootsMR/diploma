package com.cn.travel.role.user.service.imp;

import com.cn.travel.role.user.dao.UserDao;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;


    public User login(String userName,String password)throws Exception{
        return userDao.login(userName,password);
    }
    @Override
    public void save(User user) throws Exception {
        userDao.save(user);
    }

    public User findByUserName(String userName) throws Exception {
        return userDao.findByUserName(userName);
    }


}
