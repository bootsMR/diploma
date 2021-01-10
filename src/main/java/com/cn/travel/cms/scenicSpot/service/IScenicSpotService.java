package com.cn.travel.cms.scenicSpot.service;

import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;

import java.util.List;
/**
 * @title 旅游景点
 * @description
 * @author ：linkong
 * @updateTime 2021/1/8 21:52
 * @return
 * @throws
 */
public interface IScenicSpotService {
//出现旅游景点
    public long count2()throws Exception;

//分页
    public List<ScenicSpot> findByPage(int currentPage, int pageSize, String query)throws Exception;
//跳转具体页面
    public ScenicSpot findById(String id)throws Exception;


    public List<ScenicSpot> findByPage(int currentPage, int pageSize)throws Exception;



}
