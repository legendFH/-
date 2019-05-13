/*
package com.inspur.fh.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/**
 * @author fh
 * @date 2019/4/22  19:14
 *//*

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能 效果，如果没有登陆 没有权限就会重定向到登陆页面
        //1 /login 来到登录页
        //2 重定向到 /login？error 表示登陆失败
        http.formLogin();


        //开启自动配置的注销功能。
        http.logout();
        //访问/logout 注销并清空session

    }}*/
