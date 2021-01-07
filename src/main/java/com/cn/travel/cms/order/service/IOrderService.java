package com.cn.travel.cms.order.service;

import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.web.base.PageParam;

import java.util.List;
/**
 * @title 订单模块
 * @description 
 * @author ：linkong
 * @updateTime 2021/1/10 10:49
 * @return 
 * @throws 
 */
public interface IOrderService {

//保存订单
    public void save(Order notice)throws Exception;
//订单分页
    public PageParam<Order> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception;
    //通过订单ID，获取订单
    public Order findById(String id)throws Exception;
//改变订单状态
    public void update(Order notice)throws Exception;





}
