package com.cn.travel.web.portal;

import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
/**
 * @title 前台首页用户登录
 * @description
 * @author ：linkong
 * @updateTime 2020/11/15 11:53
 * @return
 * @throws
 */
@Controller
public class IndexController extends BaseController {

//跳转首页
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/index");
        return mv;
    }
//跳转登录
    @RequestMapping("/goLogin")
    public ModelAndView goLogin(HttpSession httpSession){
        if(Tools.notEmpty(httpSession.getAttribute("userName"))){
            return new ModelAndView("/index");
        }
        return new ModelAndView("/login");
    }
//退出登录
    @RequestMapping("/goLogout")
    public ModelAndView goLogout(HttpSession httpSession){
        if(Tools.notEmpty(httpSession.getAttribute("userName"))){
            httpSession.removeAttribute("userName");
        }
        return new ModelAndView("/login");
    }
}
