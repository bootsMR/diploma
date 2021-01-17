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
    //查找用户id
    public String findById() {

        return "SELECT * FROM t_pz_user WHERE ID = #{id} AND DELETE_STATUS=0";
    }
    //修改用户
    public String update(){
        return "UPDATE t_pz_user SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),USER_NAME=#{userName}, " +
                "PASSWORD=#{password},LINK_TEL=#{linkTel},NAME=#{name},IC_CODE=#{icCode},STATE=#{state},PROVINCE=#{province} WHERE id=#{id}";
    }
    //所有用户
    public String count(){
        return "SELECT count(*) FROM t_pz_user WHERE DELETE_STATUS=0";
    }

    //省份
    public String countPorvice(){
        return "SELECT p.`id` PROVICE,COUNT(u.`PROVINCE`) COUNT FROM t_pz_province p LEFT JOIN t_pz_user u ON u.`PROVINCE` = p.`id` GROUP BY p.id;";
    }
    //查询
    public String findListByQuery(){
        return "SELECT * FROM t_pz_user WHERE DELETE_STATUS=0 AND USER_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    //查询所用用户，并排序
    public String findList(){
        return "SELECT * FROM t_pz_user WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }


    //删除
    public String deleteByid(){

        return "UPDATE t_pz_user SET DELETE_STATUS=1 WHERE id=#{id}";
    }




}
