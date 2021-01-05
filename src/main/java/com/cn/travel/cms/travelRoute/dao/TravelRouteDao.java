package com.cn.travel.cms.travelRoute.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;
import com.cn.travel.cms.travelRoute.provider.TravelRouteSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName TravelRouteDao.java
 * @Description TODO
 * @createTime 2021年01月03日 21:35:00
 */
@Mapper
@Component
public interface TravelRouteDao extends BaseDao<TravelRoute> {
    //获取旅游路线
    @SelectProvider(type = TravelRouteSqlProvider.class, method = "count2")
    public long count2();

    //获取路线并且排序
    @SelectProvider(type = TravelRouteSqlProvider.class, method = "indexList")
    public List<TravelRoute> indexList();
    //跳转具体路线
    @SelectProvider(type = TravelRouteSqlProvider.class, method = "findById")
    public TravelRoute findById(@Param("id") String id);





}
