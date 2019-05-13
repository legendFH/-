package com.inspur.fh.demo.service;

import com.inspur.fh.demo.entities.Report;
import com.inspur.fh.demo.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fh
 * @date 2019/3/12  11:02
 */
@Service
public class ReportService implements ReportMapper{
    private  final ReportMapper reportMapper;
    @Autowired
    public ReportService(ReportMapper reportMapper) {
        this.reportMapper=reportMapper;
    }

    @Override
    public List<Report> findrep() {
        return reportMapper.findrep();
    }

    @Override
    public Report findrepbyid(int id) {
        return reportMapper.findrepbyid(id);
    }

    @Override
    public List<Report> findbyrep1(String report_name) {
        return reportMapper.findbyrep1(report_name);



    }

    @Override
    public int delrep(int id) {
        return reportMapper.delrep(id);
    }

    @Override
    public int updatebyrep(Report report) {
        return reportMapper.updatebyrep(report);
    }

    @Override
    public int addrep(Report report) {
        return reportMapper.addrep(report);
    }


    /* public List<Report> findrep (){
        return reportMapper.findrep();
    };
    public List<Report> findbyrep1(String report_name){
        return reportMapper.findbyrep1(report_name);
    };
    public int delrep(int id){
        return reportMapper.delrep(id);
    };
    public int updatebyrep(Report report){
        return reportMapper.updatebyrep(report);
    };
    public int addrep(Report report){
        return reportMapper.addrep(report);
    };
    public Report findrepbyid(int id){
        return reportMapper.findrepbyid(id);
    };*/
}
