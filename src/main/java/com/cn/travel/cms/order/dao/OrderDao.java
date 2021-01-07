package com.cn.travel.cms.order.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.provider.OrderSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @title 订单模块
 * @description
 * @author ：linkong
 * @updateTime 2021/1/10 10:25
 * @return
 * @throws
 */
@Mapper
@Component
public interface OrderDao extends BaseDao<Order> {
    //保存订单
    @InsertProvider(type = OrderSqlProvider.class, method = "save")
    public void save(Order notice);

    //查询用户所有订单
    @SelectProvider(type = OrderSqlProvider.class, method = "findListByUserId")
    public List<Order> findListByUserId(@Param("userId") String userId);

    //通过订单ID，获取订单
    @SelectProvider(type = OrderSqlProvider.class, method = "findById")
    public Order findById(@Param("id") String id);

    //改变订单状态
    @UpdateProvider(type = OrderSqlProvider.class, method = "update")
    public void update(Order notice);




}
