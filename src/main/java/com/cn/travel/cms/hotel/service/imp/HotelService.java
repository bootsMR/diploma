package com.cn.travel.cms.hotel.service.imp;

import com.cn.travel.cms.hotel.dao.HotelDao;
import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.service.IHotelService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @title 酒店
 * @description
 * @author ：linkong
 * @updateTime 2021/1/9 21:39
 * @return
 * @throws
 */
@Service
public class HotelService implements IHotelService {

    @Resource
    private HotelDao hotelDao;
    //查询所有酒店
    public long count()throws Exception{
        return  hotelDao.count();
    }
    //查询具体酒店
    public Hotel findById(String id)throws Exception{
        return hotelDao.findById(id);
    }
    //分页
    public List<Hotel> findByPage(int currentPage, int pageSize) {
        List<Hotel> list = new ArrayList<Hotel>();
        PageHelper.startPage(currentPage, pageSize);
        list = hotelDao.indexList();
        PageInfo<Hotel> pageInfo=new PageInfo<Hotel>(list);
        return pageInfo.getList();
    }

}
