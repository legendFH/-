package com.inspur.fh.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/*
@Configuration可理解为用spring的时候xml里面的<beans>标签

@Bean可理解为用spring的时候xml里面的<bean>标签
*/

@Configuration
/*
 implement

@Component
*/

public class SessionInterceptor implements WebMvcConfigurer {

    @Autowired
    UserIntercetor userIntercetor;


    @Override
/*
*
        *自定义拦截器，添加拦截路径和排除拦截路径
 *

    addPathPatterns():添加需要拦截的路径
 *

    excludePathPatterns():添加不需要拦截的路径
*/
    // addPathPatterns("/**") 表示拦截所有的请求，
    // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问

    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList();
        list.add("/");
        list.add("/login");
        list.add("/static/**");



        registry.addInterceptor(userIntercetor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
