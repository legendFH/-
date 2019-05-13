package com.inspur.fh.demo.controller;

import com.inspur.fh.demo.entities.User;
import com.inspur.fh.demo.service.UserService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/tonav")
    public String nav() {
        return "nav";
    }

    @GetMapping(value = "/toindex")
    public String toindex() {

        return "index";
    }






    @GetMapping(value = "/toworkSearch")
    public String work() {
        return "workmanager/workSearch";
    }

    @GetMapping(value = "/torestSearch")
    public String rest() {
        return "restmanager/restSearch";
    }

    @GetMapping(value = "/touworksyo")
    public String worksyo() {
        return "worksyouninn/worksyouninnSearch";
    }

    @GetMapping(value = "/tourestsyo")
    public String restsyo() {
        return "restsyouninn/restsyouninnSearch";
    }

    @GetMapping(value = "/userpassword")
    public String userpassword() {
        return "user/userPasswordUpdate";
    }

    @GetMapping(value = "/mydesk")
    public String desk() {
        return "mydesktop/mydesktop";
    }


    @GetMapping(value = "/main")
    public String main(ModelMap modelMap) {


        return "main";
    }

    @GetMapping(value = "/login")
    public String login(User user,
                        String name,
                        String password,
                        ModelMap modelMap, HttpSession session/*, ModelAndView modelAndView*/) {


        /* System.out.println(userService.findAllemp());*/
        name = user.getName();
        password = user.getPassword();
        System.out.println(name);
        System.out.println(password);
        User u1 = userService.findByip(name, password);
        System.out.println(u1);

        if (u1 != null) {

            session.setAttribute("loginUser", u1);


            return "redirect:/main";


        } else {
            modelMap.addAttribute("msg", "用户名密码错误");
            return "login";
        }


    }

    @GetMapping(value = "/exit")
    public String exit() {
        return "login";
    }

}