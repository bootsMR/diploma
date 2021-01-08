package com.cn.travel.cms.scenicSpot.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.scenicSpot.provider.ScenicSpotSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @title 旅游景点
 * @description 
 * @author ：linkong
 * @updateTime 2021/1/8 21:52
 * @return 
 * @throws 
 */
@Mapper
@Component
public interface ScenicSpotDao extends BaseDao<ScenicSpot> {

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "count")
    public long count();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "count2")
    public long count2();


    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findListByQuery")
    public List<ScenicSpot> findListByQuery(@Param("query") String query);

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findList")
    public List<ScenicSpot> findList();

    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "findById")
    public ScenicSpot findById(@Param("id") String id);


    @SelectProvider(type = ScenicSpotSqlProvider.class, method = "indexList")
    public List<ScenicSpot> indexList();












}
