package com.cn.travel.web.manager;

import com.cn.travel.role.admin.entity.Admin;
import com.cn.travel.role.admin.service.imp.AdminService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
/**
 * @title 后台登录，退出登录
 * @description 
 * @author ：linkong
 * @updateTime 2021/1/12 18:53 
 * @return 
 * @throws 
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    AdminService adminService;
//登录跳转
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            return REDIRECT+"/manager/index";
        }
        return "/manager/login";
    }
    //登录
    @RequestMapping("/loging")
    public String loging(String userName,String password,RedirectAttributes redirectAttributes,HttpServletRequest request){
        if (Tools.isEmpty(userName)|| Tools.isEmpty(password)){
            redirectAttributes.addFlashAttribute("message","用户名密码不得为空!");
            return REDIRECT+"/login";
        }
        try {
            Admin admin = adminService.login(userName, password);
            if (Tools.isEmpty(admin)){
                redirectAttributes.addFlashAttribute("message","用户名不存在或密码错误!");
                return REDIRECT+"/login";
            }else{
                if (admin.getState() == 1) {
                    request.getSession().setAttribute("admin", admin);
                    return REDIRECT+"/manager/index";
                } else {
                    redirectAttributes.addFlashAttribute("message","账户已被停用!");
                    return REDIRECT+"/login";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/login";
    }
    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            request.getSession().removeAttribute("admin");
        }
        return "/manager/login";
    }
}
