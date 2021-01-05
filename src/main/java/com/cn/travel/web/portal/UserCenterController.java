package com.cn.travel.web.portal;

import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserCenterController extends BaseController {
    @Autowired
    UserService userService;
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
        mv.setViewName("/userCenter");
        return mv;
    }
    /**
     * @title 用户中心模块
     * @description
     * @author ：linkong
     * @updateTime 2021/1/5 16:36
     * @return
     * @throws
     */

    @RequestMapping("/personInfo")
    public ModelAndView personInfo(HttpSession httpSession){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",userService.findByUserName(httpSession.getAttribute("userName").toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("/personalIntro");
        return mv;
    }

    //保存信息
    @RequestMapping("/personSave")
    public String personSave(HttpServletRequest request, String id){
        User entity = null;
        try{
            if(Tools.notEmpty(id)){
                entity = userService.findById(id);
            }
            this.bindValidateRequestEntity(request,entity);
            userService.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/userCenter";
    }
    //跳转用户改密码页面
    @RequestMapping("/changePassword")
    public ModelAndView changePassword(HttpSession httpSession){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/changePassword");
        return mv;
    }
    //用户改密码
    @RequestMapping("/changePasswordSave")
    public ModelAndView changePasswordSave(String password,String newPassword,String checkPassword,HttpSession httpSession) throws Exception {
        ModelAndView mv = this.getModeAndView();
        if(Tools.isEmpty(password)||Tools.isEmpty(newPassword)||Tools.isEmpty(checkPassword)){
            mv.addObject("message","密码输入不能为空！");
            mv.setViewName("/changePassword");
            return mv;
        }
        User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
        if(!user.getPassword().equals(password)){
            mv.addObject("message","原密码输入不正确！");
            mv.setViewName("/changePassword");
            return mv;
        }else if(!newPassword.equals(checkPassword)){
            mv.addObject("message","新密码与确认密码不一致！");
            mv.setViewName("/changePassword");
            return mv;
        }else{
            user.setPassword(newPassword);
            userService.update(user);
        }
        mv.setViewName("/userCenter");
        return mv;
    }



    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/test");
        return mv;
    }

}
