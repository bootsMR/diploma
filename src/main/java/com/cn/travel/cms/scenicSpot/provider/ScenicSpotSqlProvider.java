package com.cn.travel.cms.scenicSpot.provider;

import org.springframework.stereotype.Component;
/**
 * @title 旅游景点
 * @description
 * @author ：linkong
 * @updateTime 2021/1/8 21:52
 * @return
 * @throws
 */
@Component
public class ScenicSpotSqlProvider {

    public String count(){ return "SELECT count(*) FROM t_cms_scenic_spot WHERE DELETE_STATUS=0"; }
    public String count2(){ return "SELECT count(*) FROM t_cms_scenic_spot WHERE DELETE_STATUS=0 AND STATE=1"; }


    public String findListByQuery(){
        return "SELECT * FROM t_cms_scenic_spot WHERE DELETE_STATUS=0 AND SPOT_NAME LIKE #{query,jdbcType=VARCHAR} ORDER BY ADD_TIME DESC";
    }

    public String findList() {
        return "SELECT * FROM t_cms_scenic_spot WHERE DELETE_STATUS=0 ORDER BY ADD_TIME DESC";
    }

    public String findById() {
        return "SELECT * FROM t_cms_scenic_spot WHERE ID = #{id} AND DELETE_STATUS=0 ";
    }


    public String indexList(){
        return "SELECT * FROM t_cms_scenic_spot WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }



}
