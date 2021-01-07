package com.cn.travel.cms.order.provider;

import org.springframework.stereotype.Component;
/**
 * @title 订单模块
 * @description
 * @author ：linkong
 * @updateTime 2021/1/10 10:40
 * @return
 * @throws
 */
@Component
public class OrderSqlProvider {
    //保存订单
    public String save(){
        return "INSERT INTO t_yw_order(ID,ADD_USER_ID,ADD_TIME,USER_ID,USER_NAME,PRODUCT_ID,PRODUCT_NAME,FEE,PRODUCT_TYPE,STATE,ORDER_CODE,ORDER_TIME," +
                "SETOFF_TIME,LINK_TEL,PEOPLE_COUNT,REQUIREMENT,IC_CODE,IMG_URL) VALUES(#{id},#{addUserId},NOW(),#{userId},#{userName},#{productId},#{productName}," +
                "#{fee},#{productType},#{state},#{orderCode},#{orderTime},#{setoffTime},#{linkTel},#{peopleCount},#{requirement},#{icCode},#{imgUrl})";
    }
    //查询用户所有订单
    public String findListByUserId(){
        return "SELECT * FROM t_yw_order WHERE USER_ID=#{userId} AND DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    //通过订单ID，获取订单
    public String findById() {
        return "SELECT * FROM t_yw_order WHERE ID = #{id} AND DELETE_STATUS=0";
    }

    //改变订单状态
    public String update(){
        return "UPDATE t_yw_order SET MODIFY_USER_ID=#{modifyUserId},MODIFY_TIME=NOW(),USER_ID=#{userId},USER_NAME=#{userName}," +
                " PRODUCT_ID=#{productId},PRODUCT_NAME=#{productName},FEE=#{fee},PRODUCT_TYPE=#{productType},STATE=#{state}," +
                "ORDER_CODE=#{orderCode},ORDER_TIME=#{orderTime},SETOFF_TIME=#{setoffTime},LINK_TEL=#{linkTel},PEOPLE_COUNT=#{peopleCount}" +
                ",REQUIREMENT=#{requirement},IC_CODE=#{icCode},IMG_URL=#{imgUrl} WHERE id=#{id}";
    }


}
