package com.cn.travel.cms.insurance.dao;

import com.cn.travel.base.dao.BaseDao;
import com.cn.travel.cms.insurance.entity.Insurance;
import com.cn.travel.cms.insurance.provider.InsuranceSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface InsuranceDao extends BaseDao<Insurance> {
    @SelectProvider(type = InsuranceSqlProvider.class, method = "findById")
    public Insurance findById(@Param("id") String id);

    @SelectProvider(type = InsuranceSqlProvider.class, method = "indexList")
    public List<Insurance> indexList();

    @SelectProvider(type = InsuranceSqlProvider.class, method = "state1count")
    public long state1count();
}
