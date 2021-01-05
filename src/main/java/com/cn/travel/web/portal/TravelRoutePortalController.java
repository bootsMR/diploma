package com.cn.travel.web.portal;


import com.cn.travel.cms.travelRoute.service.imp.TravelRouteService;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TravelRoutePortalController.java
 * @Description TODO
 * @createTime 2021年01月03日 21:34:00
 */
@Controller
public class TravelRoutePortalController extends BaseController {

    @Autowired
    TravelRouteService travelRouteService;
    @Autowired
    UserService userService;
//旅游路线
    @RequestMapping("/travelRoute")
    public ModelAndView travelRoute(PageParam pageParam){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = travelRouteService.count2();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pageParam.setCount(count);
            if(count<=7){
                pageParam.setSize(1);
            }else{
                pageParam.setSize(count%7==0?count/7:count/7+1);
            }
            pageParam.setPageNumber(1);
            pageParam.setPageSize(7);
        }
        mv.addObject("pageData", travelRouteService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize()));
        mv.addObject("pageParam",pageParam);
        mv.setViewName("/route_list");
        return mv;
    }



    //旅游详细页面
    @RequestMapping("/travelRoutePortalView")
    public ModelAndView travelRoutePortalView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",travelRouteService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("/travelRouteView");
        return mv;
    }


}
