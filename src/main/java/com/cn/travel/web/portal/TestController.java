package com.cn.travel.web.portal;

import com.cn.travel.web.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2021年01月07日 11:20:00
 */
public class TestController extends BaseController {

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("/test");
        return mv;
    }
}
