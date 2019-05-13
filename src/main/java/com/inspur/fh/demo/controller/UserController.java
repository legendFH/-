package com.inspur.fh.demo.controller;

import com.inspur.fh.demo.entities.User;
import com.inspur.fh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/touserSearch")
    public String userss(ModelMap modelMap) {
        modelMap.addAttribute("emp", userService.findAlluser());
        return "user/userSearch";
    }

   /* @ResponseBody
    @GetMapping(value = "/touserSearchAJAX")
    public List<User> touserSearchAJAX() {
        return userService.findAlluser();
    }*/

    @GetMapping(value = "/userinsert")
    public String insert() {
        return "user/userInsert";
    }


    //传到页面value
    @GetMapping(value = "/userupdate")
    public String update(int i, HttpSession session) {
        User user2 = userService.findbyid(i);
        session.setAttribute("user2", user2);
        return "user/userUpdate";
    }





    @GetMapping(value = "/douserinsert")
    public String doinsert(User user, HttpSession session1) {
        System.out.println("hello");
        System.out.println(user.toString());
        userService.addUser(user);
        session1.setAttribute("tip", "您已增加成功");

        return "redirect:/touserSearch";
    }
    //删除功能
//    @RequestMapping(value="/del.html")
//    @ResponseBody
//    public String delStansard(List<User> users){ //传过来的是一个名叫ids的数组
//        try {
//            //批量删除
//          userService.batchDelete(users);//删除的方法
//        } catch (Exception e) {
//            // TODO: handle exception
//            return "error";
//        }
//        return "ok";
//    }

    @GetMapping(value = "/deluser")
    public String del(int i, HttpSession session1) {
        userService.deleteByID(i);
        session1.setAttribute("tip", "您已删除成功");
        return "redirect:/touserSearch";
    }
    //批量删除
    @GetMapping (value = "/delalluser")
    public String deleteManyRest(String account){
        System.out.println("------------"+account);
        String[] split = account.split(",");
        for (String a : split){
          userService.deleteByaccount(a);
            System.out.println(account.toString());
        }
        return "redirect:/touserSearch";
    }
  /*  @GetMapping(value = "/findbyid")
    public User findid(int i,HttpSession session) {
      User user2 =userService.findbyid(i);
    session.setAttribute("user2",user2);
        return user2;
    }*/

    @GetMapping(value = "/doupdateuser")
    public String up(String account, String password, String name, String department, String sex, String mobile, Date birthday, String email, HttpSession session1) {
        userService.updateByid(account, password, name, department, sex, mobile, birthday, email);
        System.out.println(account.toString());
        session1.setAttribute("tip", "您已更改成功");
        return "redirect:/touserSearch";
    }

    @GetMapping(value = "/findbyname")
    public String findname(String name, String department, ModelMap modelMap) {

        List<User> user = userService.findbyname(name);
        List<User> user1 = userService.findbydep(department);
        List<User> user2 = userService.findbydepname(name, department);

        modelMap.addAttribute("emp", user);
        modelMap.addAttribute("emp", user1);
        modelMap.addAttribute("emp", user2);
        return "user/userSearch";
    }


}

