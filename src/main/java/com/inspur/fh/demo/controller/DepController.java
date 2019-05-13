package com.inspur.fh.demo.controller;

import com.inspur.fh.demo.entities.Department;
import com.inspur.fh.demo.entities.User;
import com.inspur.fh.demo.service.DepartmentService;
import com.inspur.fh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author fh
 * @date 2019/3/11  10:27
 */
@Controller
public class DepController {
    @Autowired
    private DepartmentService departmentService;

    public DepController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/todeptSearch")
    public String dept(ModelMap modelMap) {
        modelMap.addAttribute("dep", departmentService.finddep());
        return "dept/deptSearch";
    }

    @GetMapping(value = "/todepinsert")
    public String todepinsert() {
        return "dept/deptInsert";
    }

    @GetMapping(value = "/dodepinsert")
    public String doinsert(Department department, HttpSession session1) {
        System.out.println("hello");

        departmentService.adddep(department);
        session1.setAttribute("tip1", "您已增加成功");

        return "redirect:/todeptSearch";
    }

    @GetMapping(value = "/todepupdate")
    public String todepupdate( int i, HttpSession session) {
        System.out.println(i);
        Department department2 = departmentService.finddepbyid(i);
        session.setAttribute("dep2", department2);
        return "dept/deptUpdate";
    }



    @GetMapping (value = "/dodepupdate")
    public String depup(Department department, HttpSession session1) {
        departmentService.updatebydep(department);
        session1.setAttribute("tip1", "您已更改成功");
        return "redirect:/todeptSearch";
    }

    @GetMapping(value = "/deldep")
    public String deldep(int i, HttpSession session1) {
        departmentService.deldep(i);
        session1.setAttribute("tip1", "您已删除成功");
        return "redirect:/todeptSearch";
    }
    @GetMapping (value = "/delalldep")
    public String deletedepRest(String department_id){

        String[] split = department_id.split(",");
        for (String a : split){
            departmentService.delalldep(a);

        }
        return "redirect:/todeptSearch";
    }

    @GetMapping(value = "/findbydepname")
    public String findname(String department_name, ModelMap modelMap) {

        List<Department> d1 = departmentService.findbydep1(department_name) ;


        System.out.println(d1);
        modelMap.addAttribute("dep",d1);

        return "dept/deptSearch";
    }


}
