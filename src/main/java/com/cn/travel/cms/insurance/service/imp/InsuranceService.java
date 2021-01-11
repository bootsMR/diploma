package com.cn.travel.cms.insurance.service.imp;


import com.cn.travel.cms.insurance.dao.InsuranceDao;
import com.cn.travel.cms.insurance.entity.Insurance;
import com.cn.travel.cms.insurance.service.IInsuranceService;
import com.cn.travel.utils.Tools;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceService implements IInsuranceService {
    @Resource
    private InsuranceDao insuranceDao;


    public long state1count()throws Exception{
        return  insuranceDao.state1count();
    }
    public List<Insurance> findByPage(int currentPage, int pageSize) {
        List<Insurance> list = new ArrayList<Insurance>();
        PageHelper.startPage(currentPage, pageSize);
        list = insuranceDao.indexList();
        PageInfo<Insurance> pageInfo=new PageInfo<Insurance>(list);
        return pageInfo.getList();
    }
    public Insurance findById(String id)throws Exception{
        return insuranceDao.findById(id);
    }


}
