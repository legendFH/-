package com.inspur.fh.demo.controller;

import com.inspur.fh.demo.entities.Report;
import com.inspur.fh.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * @author fh
 * @date 2019/3/11  15:29
 */
@Controller
public class ReportController {
    @Autowired
   private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService=reportService;
    }

    @GetMapping(value = "/toreportSearch")
    public String repss1111(ModelMap modelMap) {
        modelMap.addAttribute("rep", reportService.findrep());
        return "report/reportSearch";
    }

    @GetMapping(value = "/reportinsert")
    public String insert1111() {
        return "report/reportInsert";
    }


    //传到页面value
    @GetMapping(value = "/reportupdate")
    public String update1111(int i, HttpSession session) {
        Report r1 = reportService.findrepbyid(i);
        session.setAttribute("rep1", r1);
        return "report/reportUpdate";
    }

    @GetMapping(value = "/doreportinsert")
    public String doinsert1111(Report report, HttpSession session) {
        System.out.println("hello");

       reportService.addrep(report);
        session.setAttribute("reptip", "您已增加成功");

        return "redirect:/toreportSearch";
    }

    @GetMapping(value = "/delrep")
    public String del111(int i, HttpSession session) {
        reportService.delrep(i);
        session.setAttribute("reptip", "删除成功");
        return "redirect:/toreportSearch";
    }


    @GetMapping(value = "/doupdaterep")
    public String up111(Report report, HttpSession session) {
        reportService.updatebyrep(report);
        session.setAttribute("reptip", "更改成功");

        return "redirect:/toreportSearch";
    }

    @GetMapping(value = "/findbyrepname")
    public String findname111(String report_name, ModelMap modelMap) {

        List<Report> r1 = reportService.findbyrep1(report_name);

        modelMap.addAttribute("rep", r1);

        return "report/reportSearch";
    }
}
