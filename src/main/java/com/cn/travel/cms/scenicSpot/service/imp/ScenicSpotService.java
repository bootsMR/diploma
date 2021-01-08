package com.cn.travel.cms.scenicSpot.service.imp;

import com.cn.travel.cms.scenicSpot.dao.ScenicSpotDao;
import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.scenicSpot.service.IScenicSpotService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScenicSpotService implements IScenicSpotService {

    @Resource
    private ScenicSpotDao scenicSpotDao;



    public long count2()throws Exception{
        return  scenicSpotDao.count2();
    }


    public List<ScenicSpot> findByPage(int currentPage, int pageSize, String query) {
        List<ScenicSpot> list = new ArrayList<ScenicSpot>();
        PageHelper.startPage(currentPage, pageSize);
        if (Tools.notEmpty(query)) {
            list = scenicSpotDao.findListByQuery("%" + query + "%");
        } else {
            list = scenicSpotDao.findList();
        }
        PageInfo<ScenicSpot> pageInfo=new PageInfo<ScenicSpot>(list);
        return pageInfo.getList();
    }

    public ScenicSpot findById(String id)throws Exception{
        return scenicSpotDao.findById(id);
    }



    public long count()throws Exception{
        return  scenicSpotDao.count();
    }



    public List<ScenicSpot> findList()throws Exception{
        return scenicSpotDao.findList();
    }


    public List<ScenicSpot> findByPage(int currentPage, int pageSize) {
        List<ScenicSpot> list = new ArrayList<ScenicSpot>();
        PageHelper.startPage(currentPage, pageSize);
        list = scenicSpotDao.indexList();
        PageInfo<ScenicSpot> pageInfo=new PageInfo<ScenicSpot>(list);
        return pageInfo.getList();
    }

}
