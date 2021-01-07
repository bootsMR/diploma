package com.cn.travel.cms.order.service.imp;

import com.cn.travel.cms.order.dao.OrderDao;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.IOrderService;
import com.cn.travel.web.base.PageParam;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * @title 订单模块
 * @description
 * @author ：linkong
 * @updateTime 2021/1/10 11:01
 * @return
 * @throws
 */
@Service
public class OrderService implements IOrderService {


    @Resource
    private OrderDao orderDao;

    //保存订单
    @Override
    public void save(Order notice)throws Exception{
        orderDao.save(notice);
    }
    //订单分页
    public PageParam<Order> findByPageByUserId(int currentPage, int pageSize, String userId)throws Exception{
        PageParam<Order> pageParam = new PageParam<>();
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Order> list = orderDao.findListByUserId(userId);
        pageParam.setResult(list);
        pageParam.setSize(page.getPages());
        pageParam.setCount(page.getTotal());
        pageParam.setPageNumber(currentPage);
        pageParam.setPageSize(pageSize);
        return pageParam;
    }


    //通过订单ID，获取订单
    public Order findById(String id)throws Exception{
        return orderDao.findById(id);
    }
    //改变订单状态
    public void update(Order notice)throws Exception{
        orderDao.update(notice);
    }


}
