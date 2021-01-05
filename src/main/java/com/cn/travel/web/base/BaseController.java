package com.cn.travel.web.base;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Controller
public class BaseController {
    private static Lock lock = new ReentrantLock();
    private static List<ModelAndView> modeAndViewsPool = Lists.newArrayListWithCapacity(20);
 /**
  * @title
  * @description 重定向标记(客户端行为)
  * @author ：linkong
  * @updateTime 2021/12/4 15:26
  * @return
  * @throws
  */

    public static final String REDIRECT = "redirect:";


    /**
     * @title
     * @description  数据转换组件
     * @author ：linkong
     * @updateTime 2021/12/4 15:26
     * @return
     * @throws
     */

    @Autowired
    protected ConversionService conversionService;


    /**
     * @title
     * @description 取ModelAndView
     * @author ：linkong
     * @updateTime 2021/12/4 15:26
     * @return
     * @throws
     */
   public static ModelAndView getModeAndView() {
        try {
            lock.lock();
            if (modeAndViewsPool.size() > 0) {
                return modeAndViewsPool.remove(0);
            }
        }finally{
            lock.unlock();
        }
        return new ModelAndView();
    }


    /**
     * @title
     * @description 邦定表单数据并且校验数据
     * @author ：linkong
     * @updateTime 2021/12/4 15:25
     * @return
     * @throws ConstraintViolationException
     */
    protected void bindValidateRequestEntity(HttpServletRequest request, Object entity) throws ConstraintViolationException {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(entity);
        binder.setConversionService(conversionService);
        binder.bind(request);
    }
}
