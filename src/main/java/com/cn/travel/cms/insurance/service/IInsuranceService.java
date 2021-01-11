package com.cn.travel.cms.insurance.service;

import com.cn.travel.cms.insurance.entity.Insurance;

import java.util.List;

public interface IInsuranceService {


    public Insurance findById(String id)throws Exception;

    public List<Insurance> findByPage(int currentPage, int pageSize)throws Exception;

    public long state1count()throws Exception;

}
