package com.cn.travel.web.manager;


import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title 后台跳转
 * @description 
 * @author ：linkong
 * @updateTime 2021/1/12 11:53
 * @return
 * @throws 
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    @Autowired
    UserService userService;
//首页跳转
    @RequestMapping("/index")
    public ModelAndView manager(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/manager/index");
        return mv;
    }
    //后台首页
    @RequestMapping("/main")
    public ModelAndView main() throws Exception {
        ModelAndView mv = this.getModeAndView();
        mv.addObject("porvice",userService.countPorvice());
        mv.setViewName("/manager/main");
        return mv;
    }

}
