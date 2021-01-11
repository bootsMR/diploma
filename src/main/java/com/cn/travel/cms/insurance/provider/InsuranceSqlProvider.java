package com.cn.travel.cms.insurance.provider;

import org.springframework.stereotype.Component;

@Component
public class InsuranceSqlProvider {
    public String state1count(){ return "SELECT count(*) FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=1"; }

    public String indexList(){
        return "SELECT * FROM t_cms_insurance WHERE DELETE_STATUS=0 AND STATE=1 ORDER BY ADD_TIME DESC";
    }

    public String findById() {
        return "SELECT * FROM t_cms_insurance WHERE ID = #{id} AND DELETE_STATUS=0";
    }

}
