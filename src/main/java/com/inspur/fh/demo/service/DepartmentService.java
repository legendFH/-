package com.inspur.fh.demo.service;

import com.inspur.fh.demo.entities.Department;
import com.inspur.fh.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fh
 * @date 2019/3/11  10:21
 */
@Service
public class DepartmentService {
    @Autowired
    private final DepartmentMapper departmentMapper;


    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> finddep (){
        return departmentMapper.finddep();
    };
    public List<Department> findbydep1(String department_name){
        return departmentMapper.findbydep1(department_name);
    };
    public int deldep(int id){
        return departmentMapper.deldep(id);
    };
    public int delalldep(String department_id)
    {
        return departmentMapper.delalldep(department_id);
    };
    public int updatebydep(Department department){
        return departmentMapper.updatebydep(department);
    };
    public int adddep(Department department){
        return departmentMapper.adddep(department);
    };
    public Department finddepbyid(int id){
        return departmentMapper.finddepbyid(id);
    };



}
