package com.cn.travel.cms.hotel.service;

import com.cn.travel.cms.hotel.entity.Hotel;
/**
 * @title 酒店
 * @description
 * @author ：linkong
 * @updateTime 2021/1/9 21:39
 * @return
 * @throws
 */
import java.util.List;

public interface IHotelService {

    public long count()throws Exception;
    public List<Hotel> findByPage(int currentPage, int pageSize)throws Exception;
    public Hotel findById(String id)throws Exception;



}
