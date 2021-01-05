package com.cn.travel.cms.travelRoute.provider;

import org.springframework.stereotype.Component;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName TravelRouteSqlProvider.java
 * @Description TODO
 * @createTime 2021年01月03日 21:35:22
 */
@Component
public class TravelRouteSqlProvider {

    //获取旅游路线
    public String count2(){ return "SELECT count(*) FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=1"; }

    //获取路线并且排序
    public String indexList(){
        return "SELECT * FROM t_cms_travel_route WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }
    //跳转具体路线
    public String findById() {
        return "SELECT * FROM t_cms_travel_route WHERE ID = #{id} AND DELETE_STATUS=0";
    }




}
