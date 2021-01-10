package com.cn.travel.cms.hotel.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.provider.HotelSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @title 酒店
 * @description  HotelDao
 * @author ：linkong
 * @updateTime 2021/1/9 21:39
 * @return
 * @throws
 */
@Mapper
@Component
public interface HotelDao extends BaseDao<Hotel> {
    //查询所有
    @SelectProvider(type = HotelSqlProvider.class, method = "count")
    public long count();
    //查询具体
    @SelectProvider(type = HotelSqlProvider.class, method = "findById")
    public Hotel findById(@Param("id") String id);
    //按照时间查询所有酒店信息
    @SelectProvider(type = HotelSqlProvider.class, method = "indexList")
    public List<Hotel> indexList();



}
