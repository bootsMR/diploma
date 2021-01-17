package com.cn.travel.role.user.service.imp;

import com.cn.travel.role.user.dao.UserDao;
import com.cn.travel.role.user.entity.Porvice;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.IUserService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Override
    public User findByUserName(String userName) throws Exception {
        return userDao.findByUserName(userName);
    }
    @Override
    public User findById(String id)throws Exception{
        return userDao.findById(id);
    }
    @Override
    public void update(User user)throws Exception{
        userDao.update(user);
    }

    public List<Porvice> countPorvice()throws Exception{
        return userDao.countPorvice();
    }

    public long count()throws Exception{
        return userDao.count();
    }

    public List<User> findByPage(int currentPage,int pageSize, String query) {
        List<User> list = new ArrayList<User>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = userDao.findListByQuery("%" + query + "%");
        } else {
            list = userDao.findList();
        }
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        return pageInfo.getList();
    }

    public void deleteByid(String id)throws Exception{
        userDao.deleteByid(id);
    }

}
