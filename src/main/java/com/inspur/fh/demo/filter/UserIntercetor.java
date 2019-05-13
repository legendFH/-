package com.inspur.fh.demo.filter;


import com.inspur.fh.demo.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*
        *

@author fu
        *@Date 19点57分
*/


@Component
public class UserIntercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行到了preHandle方法");
        System.out.println(handler);
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/");//拦截后跳转的方法
            System.out.println("成功拦截并跳转");
            return true;
        }
        System.out.println("合格放行");
        return true;
    }
    /*

     *处理请求完成后视图渲染之前的处理操作
     *通过ModelAndView参数改变显示的视图，或发往视图的方法


    @Override

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了postHandle方法");
    }
    /* *视图渲染之后的操作*/


    @Override

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行到了afterCompletion方法");

    }
}
