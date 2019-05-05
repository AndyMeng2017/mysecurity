package com.imooc.web.interceptor;

import com.imooc.web.controller.ControllerExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandler");

        System.out.println(((HandlerMethod)o).getBean().getClass().getName());
        System.out.println(((HandlerMethod)o).getMethod().getName());
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时为：" + (System.currentTimeMillis() - start));
    }

    /**
     * 若是声明了 {@link ControllerExceptionHandler} ，这里的 Exception 就捕获不到，因为自定义异常捕获先执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        long start = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时为：" + (System.currentTimeMillis() - start));
        System.out.println("ex is：" + e);
    }
}
