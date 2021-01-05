package com.cn.travel.cms.travelRoute.service;

import com.cn.travel.cms.travelRoute.entity.TravelRoute;

import java.util.List;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName ITravelRouteService.java
 * @Description TODO
 * @createTime 2021年01月03日 21:35:22
 */
public interface ITravelRouteService {

    //获取旅游路线
    public long count2()throws Exception;
    //分页
    public List<TravelRoute> findByPage(int currentPage, int pageSize)throws Exception;

    //跳转具体路线
    public TravelRoute findById(String id)throws Exception;
}
