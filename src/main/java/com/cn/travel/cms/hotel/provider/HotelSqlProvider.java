package com.cn.travel.cms.hotel.provider;

import org.springframework.stereotype.Component;
/**
 * @title 酒店
 * @description HotelSqlProvider
 * @author ：linkong
 * @updateTime 2021/1/9 21:39
 * @return
 * @throws
 */
@Component
public class HotelSqlProvider {
    //查询所有
    public String count(){ return "SELECT count(*) FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=1"; }
    //查询具体
    public String findById() {
        return "SELECT * FROM t_cms_hotel WHERE ID = #{id} AND DELETE_STATUS=0";
    }
    //按照时间查询所有酒店信息
    public String indexList(){
        return "SELECT * FROM t_cms_hotel WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }


}
