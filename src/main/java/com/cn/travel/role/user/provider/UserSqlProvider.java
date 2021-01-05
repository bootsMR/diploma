package com.cn.travel.role.user.provider;

import com.cn.travel.role.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserSqlProvider {
    /**
     * @title 前台页面登录
     * @description
     * @author ：linkong
     * @updateTime 2020/11/15 15:54
     * @return
     * @throws
     */
    //登录
    public String login() {
        return "SELECT * FROM t_pz_user WHERE USER_NAME = #{userName} AND PASSWORD = #{password} AND DELETE_STATUS=0";
    }

//注册
    public String save(){
        return "INSERT INTO t_pz_user(ID,ADD_USER_ID,ADD_TIME,USER_NAME,PASSWORD,LINK_TEL,NAME,IC_CODE,STATE,PROVINCE) VALUES" +
                "(#{id},#{addUserId},NOW(),#{userName},#{password},#{linkTel},#{name},#{icCode},#{state},#{province})";
    }
    //查找用户名
    public String findByUserName() {
        return "SELECT * FROM t_pz_user WHERE USER_NAME = #{userName} AND DELETE_STATUS=0";
    }


}
