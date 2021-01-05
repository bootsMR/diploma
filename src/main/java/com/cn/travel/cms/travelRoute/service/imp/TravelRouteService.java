package com.cn.travel.cms.travelRoute.service.imp;

import com.cn.travel.cms.travelRoute.dao.TravelRouteDao;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;
import com.cn.travel.cms.travelRoute.service.ITravelRouteService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName TravelRouteService.java
 * @Description TODO
 * @createTime 2021年01月03日 21:36:22
 */
@Service
public class TravelRouteService implements ITravelRouteService {

    @Resource
    private TravelRouteDao travelRouteDao;

//获取旅游路线
    public long count2()throws Exception{
        return travelRouteDao.count2();
    }

//分页
    public List<TravelRoute> findByPage(int currentPage, int pageSize) {
        List<TravelRoute> list = new ArrayList<TravelRoute>();
        PageHelper.startPage(currentPage, pageSize);
        list = travelRouteDao.indexList();
        PageInfo<TravelRoute> pageInfo=new PageInfo<TravelRoute>(list);
        return pageInfo.getList();
    }
    //跳转具体路线
    public TravelRoute findById(String id)throws Exception{
        return travelRouteDao.findById(id);
    }

}
