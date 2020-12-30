package com.cn.travel.web.portal;

import com.cn.travel.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCenterController extends BaseController {
/**
 * @title 用户登录后出现个人中心
 * @description 
 * @author ：linkong
 * @updateTime 2020/11/15 16:44
 * @return
 * @throws 
 */
    @RequestMapping("/userCenter")
    public ModelAndView userCenter(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("portal/userCenter");
        return mv;
    }
    @RequestMapping("/test")
    public ModelAndView testCenter(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/index");
        return mv;
    }

}
